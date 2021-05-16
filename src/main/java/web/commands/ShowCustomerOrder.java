package web.commands;

import business.entities.Order;
import business.exceptions.UserException;
import com.sun.tools.corba.se.idl.constExpr.Or;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ShowCustomerOrder extends CommandProtectedPage {
    public ShowCustomerOrder(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();
        Order order = null;
        String orderId = request.getParameter("customerorder");
        int orderIdInt = Integer.parseInt(orderId);
        List<Order> orderList = (List<Order>) session.getAttribute("orderList");

        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getOrderId() == orderIdInt){
                order = orderList.get(i);
                session.setAttribute("order",order);
            } else {
                request.setAttribute("error","Der er sket en fejl");
            }
        }
        session.setAttribute("order",order);
    //TODO: Gør order ikke null
        return pageToShow;
    }
}
