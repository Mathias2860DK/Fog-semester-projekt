package web.commands;

import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectCommand extends CommandUnprotectedPage {
    public RedirectCommand(String pageToShow) {
        super(pageToShow);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        //only purpose of this Command class is to redirect to the correct page.
       String carportdesign = request.getParameter("designcarport");
       if (carportdesign != null){
           return "designcarport";
       }
        return pageToShow;
    }
}
