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
                System.out.println(order.getCarport().getShed());
                session.setAttribute("order",order);
                return pageToShow;
            } else {
                request.setAttribute("error","Der er sket en fejl");
            }
        }


        return pageToShow;
    }
}
