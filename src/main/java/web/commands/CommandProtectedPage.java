package web.commands;

import business.entities.Order;
import business.exceptions.UserException;
import business.persistence.OrderMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CommandProtectedPage extends Command {
    public String role;
    public String pageToShow;
    private OrderMapper orderMapper;

    public CommandProtectedPage(String pageToShow, String role) {
        this.pageToShow = pageToShow;
        this.role = role;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {//TODO: Pak væk
        return pageToShow;
    }

    public String getRole() {
        return role;
    }
}
