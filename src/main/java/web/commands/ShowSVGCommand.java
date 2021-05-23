package web.commands;

import business.entities.Carport;
import business.entities.Shed;
import business.exceptions.UserException;
import business.services.svg.SVG;
import business.services.svg.SvgTop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowSVGCommand extends CommandUnprotectedPage {
    public ShowSVGCommand(String pageToShow) {
        super(pageToShow);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        HttpSession session = request.getSession();

        Carport carport = null;
        boolean hasShed = false;
        //makes sure that the parameters will be initialized.
        int carportWidthInt = 0;
        int carportLengthInt = 0;
        String carportWidth = request.getParameter("carport_width");
        String carportLength = request.getParameter("carport_length");
        String carportShedSize = request.getParameter("shed-size");
        String roof = request.getParameter("roof");//TODO try catch ting

        String showSvg = request.getParameter("showSvg");

        try {
            carportWidthInt = Integer.parseInt(carportWidth);
            carportLengthInt = Integer.parseInt(carportLength);

        } catch (NumberFormatException e) {
            request.setAttribute("error", "Du mangler at udfylde et eller flere felter");
            return pageToShow;
        }

        if (!carportShedSize.equals("no-shed")){
            hasShed = true;
        }

        if (showSvg != null && roof != null) {
            if (hasShed && carportLengthInt > 510) {
                Shed shed = new Shed(carportWidthInt);

                if (carportShedSize.equals("halfSize")) {
                    shed.setFullSize(false);
                } else {
                    shed.setFullSize(true);
                }
                carport = new Carport(carportWidthInt, carportLengthInt, roof, shed);
                carport.getShed().setHasShed(true);
            } else if (hasShed && carportLengthInt <511){
                carport = new Carport(carportWidthInt, carportLengthInt, roof);
                request.setAttribute("error","Du kan ikke tilvælge redskabsskur med en carport længde på under 540 cm");

            } else {
                Shed shed = new Shed(carportWidthInt);
                shed.setShedWidthIfNoShed();
                carport = new Carport(carportWidthInt, carportLengthInt, roof,shed);
            }
            session.setAttribute("carport", carport);

            //creates SVG from the top of the carport

            SVG svg = new SVG(0, 0, "0 0 1000 900", 150, 100, carport);
            String svgCode = svg.generateSvgTop();
            request.setAttribute("svgdrawing", svgCode);

            //Create SVG from the side of the carport
            SVG svgSide = new SVG(0, 0, "0 0 1000 900", 150, 100, carport);
            String svgCodeSide = svgSide.generateSvgSide();
            request.setAttribute("svgdrawingside", svgCodeSide);
        }
        return pageToShow;
    }
}