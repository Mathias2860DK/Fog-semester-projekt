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

        String salesprice = (String) session.getAttribute("salesprice");
        String sendOfferToId = request.getParameter("sendOfferToId");
        String statusPaid = request.getParameter("statusPaid");

        if (sendOfferToId != null) {

            int sendOfferToIdInt = Integer.parseInt(sendOfferToId);
            order = orderFacade.getOrderById(sendOfferToIdInt);
            order.setTotalprice(Double.parseDouble(salesprice));
            String status = "offer sent";
            int rowsAffected = orderFacade.updateStatusAndPrice(sendOfferToIdInt, status, order.getTotalprice());
            session.setAttribute("order",order);
            if (rowsAffected == 1){
                request.setAttribute("succes","Kundens status er nu ændret");
            } else {
                request.setAttribute("error","Der er sket en fejl. Kontakt IT");
            }
        }

        if (statusPaid != null){
            int orderIdPaid = Integer.parseInt(statusPaid);
            order = orderFacade.getOrderById(orderIdPaid);
            int rowsAffected = orderFacade.updateStatus(orderIdPaid,"paid");
            session.setAttribute("order",order);
            if (rowsAffected == 1){
                request.setAttribute("sucess","Kundens status er nu ændret");
            } else {
                request.setAttribute("error","Der er sket en fejl. Kontakt IT");
            }
        }
        return pageToShow;
    }
}
