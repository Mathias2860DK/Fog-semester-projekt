package web.commands;

import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GenerateRequestBillCommand extends CommandUnprotectedPage {

    public GenerateRequestBillCommand(String pageToShow) {
        super(pageToShow);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        String name = request.getParameter("name");
        String adress = request.getParameter("adress");
        String zipCodeCity = request.getParameter("zip_code_city");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String remarks = request.getParameter("remarks");


        request.setAttribute("adress",adress);
        request.setAttribute("zip_code_city",zipCodeCity);
        request.setAttribute("phone",phone);
        request.setAttribute("email",email);
        request.setAttribute("remarks",remarks);

        request.setAttribute("name",name);
        return pageToShow;
    }
}
