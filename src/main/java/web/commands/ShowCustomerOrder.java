package web.commands;

import business.entities.Order;
import business.exceptions.UserException;
import business.services.DeliveryInfoFacade;
import business.services.OrderFacade;
import com.sun.tools.corba.se.idl.constExpr.Or;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ShowCustomerOrder extends CommandProtectedPage {
    private OrderFacade orderFacade;
    private DeliveryInfoFacade deliveryInfoFacade;
    public ShowCustomerOrder(String pageToShow, String role) {
        super(pageToShow, role);
        this.orderFacade = new OrderFacade(database);
        this.deliveryInfoFacade = new DeliveryInfoFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();
        Order order = null;
        String orderId = request.getParameter("customerorder");

        if (orderId != null) {
            int orderIdInt = Integer.parseInt(orderId);
            List<Order> orderList = (List<Order>) session.getAttribute("orderList");

            for (int i = 0; i < orderList.size(); i++) {
                if (orderList.get(i).getOrderId() == orderIdInt) {
                    order = orderList.get(i);
                    session.setAttribute("order", order);
                    return pageToShow;
                } else {
                    request.setAttribute("error", "Der er sket en fejl");
                }
            }
        }
        String delete = request.getParameter("delete-del-info-id");
        if (delete != null){
            order = (Order) session.getAttribute("order");
            int deliveryInfoId = Integer.parseInt(delete);
            orderFacade.deleteOrder(order.getOrderId());
            deliveryInfoFacade.deleteDeliveryInfo(deliveryInfoId);

            request.setAttribute("sucess","Ordren er slette");
            session.setAttribute("order",null);
            return pageToShow;
        }


        return pageToShow;
    }
}
