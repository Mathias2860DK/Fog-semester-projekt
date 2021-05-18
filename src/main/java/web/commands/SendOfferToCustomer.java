package web.commands;

import business.entities.Order;
import business.exceptions.UserException;
import business.services.OrderFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SendOfferToCustomer extends CommandProtectedPage {
    private OrderFacade orderFacade;

    public SendOfferToCustomer(String pageToShow, String role) {
        super(pageToShow, role);
        this.orderFacade = new OrderFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        Order order = null;
        HttpSession session = request.getSession();
       // double salesPrice = (double)
        String salesprice = (String) session.getAttribute("salesprice");
        String orderId = request.getParameter("sendOfferToId");
        int orderIdInt = Integer.parseInt(orderId);
        order = orderFacade.getOrderById(orderIdInt);
        order.setTotalprice(Double.parseDouble(salesprice));
        String status = "offer sent";
        orderFacade.updateStatusAndPrice(orderIdInt,status, order.getTotalprice());

        return pageToShow;
    }
}
