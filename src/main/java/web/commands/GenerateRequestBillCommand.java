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
        request.setAttribute("name",name);
        return pageToShow;
    }
}
