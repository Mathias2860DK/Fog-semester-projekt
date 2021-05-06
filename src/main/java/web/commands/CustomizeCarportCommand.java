package web.commands;

import business.entities.Carport;
import business.exceptions.UserException;

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
        int roofPitchInt = 0;
        //get request parameters from designcarport page
        String carportWidth = request.getParameter("carport_width");
        String carportLength = request.getParameter("carport_length");
        String roof = request.getParameter("roof");
        String roofPitch = request.getParameter("roof_pitch");
        String submitRequest = request.getParameter("submit_request");//Hvor skal vi hen? svg tegning eller send forespørgsel

        //This could go wrong. If it does: their values is 0.
        try {
            carportWidthInt = Integer.parseInt(carportWidth);
            carportLengthInt = Integer.parseInt(carportLength);
            roofPitchInt= Integer.parseInt(roofPitch);
        } catch (NumberFormatException e){
            e.printStackTrace();
        }


        //toolroom parameters:
        carport = new Carport(carportWidthInt,carportLengthInt,roof,roofPitchInt);

        if(submitRequest != null){
            if (carportWidthInt == 0 || carportLengthInt == 0 || roof == null || roofPitchInt == 0){//skal addes flere parametre.
request.setAttribute("error","Du mangler at udfylde et eller flere felter");
                return pageToShow;
            }
            return "deliveryinfomation";
        }

        return pageToShow;//designcarport
    }
}
