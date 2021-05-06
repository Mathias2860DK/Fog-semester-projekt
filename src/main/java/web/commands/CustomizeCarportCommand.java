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
        //get request parameters from designcarport page
        String carportWidth = request.getParameter("carport_width");
        String carportLength = request.getParameter("carport_length");
        String roof = request.getParameter("roof");
        String roofPitch = request.getParameter("roof_pitch");
        String submitRequest = request.getParameter("submit_request");//Hvor skal vi hen? svg tegning eller send forespørgsel

        int carportWidthInt = Integer.parseInt(carportWidth);
        int carportLengthInt = Integer.parseInt(carportLength);
        int roofPitchInt = Integer.parseInt(roofPitch);

        //toolroom parameters:
        carport = new Carport(carportWidthInt,carportLengthInt,roof,roofPitchInt);

        if(submitRequest != null){
            return "deliveryinfomation";
        }

        return pageToShow;//designcarport
    }
}
