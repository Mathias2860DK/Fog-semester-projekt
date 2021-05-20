package web.commands;

import business.entities.Order;
import business.exceptions.UserException;
import business.services.DeliveryInfoFacade;
import business.services.OrderFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SendOfferToCustomer extends CommandProtectedPage {
    private OrderFacade orderFacade;
    private DeliveryInfoFacade deliveryInfoFacade;
    public SendOfferToCustomer(String pageToShow, String role) {
        super(pageToShow, role);
        this.orderFacade = new OrderFacade(database);
        this.deliveryInfoFacade = new DeliveryInfoFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        Order order = null;
        HttpSession session = request.getSession();

        String salesprice = (String) session.getAttribute("salesprice");
        String sendOfferToId = request.getParameter("sendOfferToId");
        String statusPaid = request.getParameter("statusPaid");

        String email = null;


        if (sendOfferToId != null) {

            int sendOfferToIdInt = Integer.parseInt(sendOfferToId);
            order = orderFacade.getOrderById(sendOfferToIdInt);
            order.setTotalprice(Double.parseDouble(salesprice));
            String status = "offer sent";
            email = deliveryInfoFacade.getCustomerEmail(order.getDeliveryInfoId());
            order.setEmail(email);
            int rowsAffected = orderFacade.updateStatusAndPrice(sendOfferToIdInt, status, order.getTotalprice());
            order.setStatus("offer sent");
            session.setAttribute("order", order);
            if (rowsAffected == 1) {
                request.setAttribute("succes", "Kundens status er nu ændret");
            } else {
                request.setAttribute("error", "Der er sket en fejl. Kontakt IT");
            }
        }

        if (statusPaid != null) {
            int orderIdPaid = Integer.parseInt(statusPaid);
            order = orderFacade.getOrderById(orderIdPaid);
            int rowsAffected = orderFacade.updateStatus(orderIdPaid, "paid");
            email = deliveryInfoFacade.getCustomerEmail(order.getDeliveryInfoId());
            order.setEmail(email);
            session.setAttribute("order", order);
            if (rowsAffected == 1) {
                request.setAttribute("sucess", "Kundens status er nu ændret");
            } else {
                request.setAttribute("error", "Der er sket en fejl. Kontakt IT");
            }
        }
        return pageToShow;
    }
}
