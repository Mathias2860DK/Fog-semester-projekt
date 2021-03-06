package web.commands.customer;

import business.calculations.CalcCarport;
import business.entities.Carport;
import business.entities.Order;
import business.entities.Shed;
import business.exceptions.UserException;
import business.services.DeliveryInfoFacade;
import business.services.MaterialsFacade;
import business.services.OrderFacade;
import business.services.svg.SVG;
import com.sun.tools.corba.se.idl.constExpr.Or;
import web.commands.CommandProtectedPage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ShowCustomerOrder extends CommandProtectedPage {
    private OrderFacade orderFacade;
    private DeliveryInfoFacade deliveryInfoFacade;
    private MaterialsFacade materialsFacade;

    public ShowCustomerOrder(String pageToShow, String role) {
        super(pageToShow, role);
        this.orderFacade = new OrderFacade(database);
        this.deliveryInfoFacade = new DeliveryInfoFacade(database);
        this.materialsFacade = new MaterialsFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();
        Order order = null;
        String orderId = request.getParameter("customerorder");
        boolean hasShed = false;


        if (orderId != null) {
            int orderIdInt = Integer.parseInt(orderId);
            List<Order> orderList = (List<Order>) session.getAttribute("orderList");

            //Shows bom for customers who have paid:
            for (int i = 0; i < orderList.size(); i++) {
                if (orderList.get(i).getOrderId() == orderIdInt) {
                    order = orderList.get(i);
                    if (order.getStatus().equals("paid")) {
                        Carport carport = order.getCarport();
                        request.setAttribute("bomByOrderId", orderId);
                        CalcCarport calcCarport = new CalcCarport();
                        carport = calcCarport.getCarportMaterials(carport, materialsFacade);
                        session.setAttribute("carport", carport);
                    }
                }
            }

            for (int i = 0; i < orderList.size(); i++) {
                if (orderList.get(i).getOrderId() == orderIdInt) {
                    order = orderList.get(i);
                    if (order.getStatus().equals("offer sent")) {
                        request.setAttribute("offerSent", 1);
                    }
                    session.setAttribute("order", order);
                    return pageToShow;
                } else {
                    request.setAttribute("error", "Der er sket en fejl");
                }
            }
        }
        String delete = request.getParameter("delete-del-info-id");
        if (delete != null) {
            order = (Order) session.getAttribute("order");
            int deliveryInfoId = Integer.parseInt(delete);
            orderFacade.deleteOrder(order.getOrderId());
            deliveryInfoFacade.deleteDeliveryInfo(deliveryInfoId);

            request.setAttribute("sucess", "Ordren er slettet");
            session.setAttribute("order", null);
            return pageToShow;
        }
        String accept = request.getParameter("accept-del-info-id");
        if (accept != null) {
            order = (Order) session.getAttribute("order");
            orderFacade.updateStatus(order.getOrderId(), "accepted");
            request.setAttribute("sucess", "Ordren er accepteret. Du bliver kontaktet snarest muligt");
        }

        return pageToShow;
    }
}
