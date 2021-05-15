package web.commands;

import business.entities.Order;
import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowCustomerOrder extends CommandProtectedPage {
    public ShowCustomerOrder(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        Order order = (Order) request.getAttribute("customerorder");
        request.setAttribute("customerorder",order);
    //TODO: Gør order ikke null
        return pageToShow;
    }
}
