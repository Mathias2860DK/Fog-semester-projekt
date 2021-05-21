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
       /*  SVG svg = new SVG(0, 0, "0 0 800 600", 100, 50);
        SvgTop svgTop = new SvgTop(new Carport(600,780,""),svg);
        String svgTopCode = svgTop.createSvgTop();
        request.setAttribute("svgdrawing", svgTopCode.replace(",", "."));//Makes sure that it puts dot instead of comma.
        return pageToShow;*/

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
            } else if (hasShed && carportLengthInt <510){
                carport = new Carport(carportWidthInt, carportLengthInt, roof);
                request.setAttribute("error","Du kan ikke tilvælge redskabsskur med en carport længde på under 510 cm");
                return pageToShow;
            } else {
                carport = new Carport(carportWidthInt, carportLengthInt, roof);
            }
            session.setAttribute("carport", carport);
            SVG svg = new SVG(0, 0, "0 0 900 800", 100, 50, carport);
            String svgCode = svg.generateSvgTop();
            request.setAttribute("svgdrawing", svgCode);
        }
        return pageToShow;
    }
}
