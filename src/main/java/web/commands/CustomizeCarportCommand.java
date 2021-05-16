package web.commands;

import business.calculations.CalcPart;
import business.entities.Carport;
import business.entities.Shed;
import business.exceptions.UserException;
import business.services.SVG;

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
        //makes sure that the parameters will be initialized.
        int carportWidthInt = 0;
        int carportLengthInt = 0;
        //get request parameters from designcarport page
        String carportShedSize = request.getParameter("shed-size");
        String carportWidth = request.getParameter("carport_width");
        String carportLength = request.getParameter("carport_length");
        String roof = request.getParameter("roof");


        String submitRequest = request.getParameter("submit_request");//Hvor skal vi hen? svg tegning eller send forespørgsel
        String showSVG = request.getParameter("show_drawing");//Burde vise SVG tegning her på samme side

        //This could go wrong. If it does: their values is 0.
        try {
            carportWidthInt = Integer.parseInt(carportWidth);
            carportLengthInt = Integer.parseInt(carportLength);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        //Calulate carport SVG parts:
        int rafterLength = 0;//not relevant for svg
        int remLength = 0;//not relevant for svg
        int postAmount = CalcPart.calcPostAmount(carportLengthInt);
        int rafters = CalcPart.calcRafters(carportLengthInt,rafterLength);
        int remme = CalcPart.calcRem(carportLengthInt,remLength);
        if(showSVG != null){
        //TODO: Her skal tilføjes de begregninger til for mange af de forskellige matrialer der skal bruges
            SVG svg = new SVG(0, 0, "0 0 800 600", 100, 50);

            //rafters
            for (int x = 0; x < rafters; x++) {
                svg.addRect(100 + 50 * x, 0, carportLengthInt, 4.5);//4,5 rafter width
            }
            //remme
            svg.addRect(210,70,9.7,9.7);

            request.setAttribute("svgdrawing", svg.toString().replace(",","."));//Makes sure that it puts dot instead of comma.
            return pageToShow;
        }


        //toolroom parameters:

        int shedLength = 0;
        int shedWidth = 0;
        //TODO: Refactor. Mabye calculation package
        if (submitRequest != null && carportShedSize.equals("no-shed")) {
            if (carportWidthInt == 0 || carportLengthInt == 0 || roof == null || roof.equals("")) {//skal addes flere parametre.
                request.setAttribute("error", "Du mangler at udfylde et eller flere felter");
                return pageToShow;
            }
            carport = new Carport(carportWidthInt, carportLengthInt, roof);
            session.setAttribute("carport", carport);
            return "deliveryinfomation";
        } else if (submitRequest != null && carportShedSize != null) {
            shedLength = carportLengthInt / 4;
            if (carportShedSize.equals("halfSize")) {
                shedWidth = carportWidthInt / 2;
            } else {
                shedWidth = carportWidthInt;
            }
            carport = new Carport(carportWidthInt, carportLengthInt, roof, new Shed(shedLength, shedWidth));
            session.setAttribute("carport", carport);
            return "deliveryinfomation";
        }

        return pageToShow;//designcarport
    }
}
