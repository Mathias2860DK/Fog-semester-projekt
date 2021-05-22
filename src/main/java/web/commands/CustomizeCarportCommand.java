package web.commands;

import business.calculations.CalcPart;
import business.entities.Carport;
import business.entities.Shed;
import business.exceptions.UserException;
import business.services.svg.SVG;
import business.services.svg.SvgTop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CustomizeCarportCommand extends CommandUnprotectedPage {

    public CustomizeCarportCommand(String pageToShow) {
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
        //get request parameters from designcarport page
        String carportShedSize = request.getParameter("shed-size");
        String carportWidth = request.getParameter("carport_width");
        String carportLength = request.getParameter("carport_length");
        String roof = request.getParameter("roof");//TODO try catch ting


        String submitRequest = request.getParameter("submitRequest");



        //This could go wrong. If it does: their values is 0.
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


        if (submitRequest != null && roof != null){
            if (hasShed && carportLengthInt > 510) {
                Shed shed = new Shed(carportWidthInt);

                if (carportShedSize.equals("halfSize")) {
                    shed.setFullSize(false);
                } else {
                    shed.setFullSize(true);
                }
                carport = new Carport(carportWidthInt, carportLengthInt, roof, shed);
            } else if (hasShed && carportLengthInt <511){
                carport = new Carport(carportWidthInt, carportLengthInt, roof);
                request.setAttribute("error","Du kan ikke tilvælge redskabsskur med en carport længde på under 540 cm");
                return pageToShow;
            } else {
                carport = new Carport(carportWidthInt,carportLengthInt,roof);
            }
            session.setAttribute("carport",carport);
            return "deliveryinfomation";
        }


        return pageToShow;//designcarport
    }

}
