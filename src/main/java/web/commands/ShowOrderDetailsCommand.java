package web.commands;

import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowOrderDetailsCommand extends CommandProtectedPage {

    public ShowOrderDetailsCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        System.out.println("komemr vi ind her");
        return pageToShow;
    }
}
