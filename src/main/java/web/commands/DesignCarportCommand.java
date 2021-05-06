package web.commands;

import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DesignCarportCommand extends CommandUnprotectedPage {//TODO: Rename. The class only redirects to designcarport page

    public DesignCarportCommand(String pageToShow) {
        super(pageToShow);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        return pageToShow;
    }
}
