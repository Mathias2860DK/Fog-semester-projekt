package web.commands.customer;

import business.calculations.CalcCarport;
import business.entities.Carport;
import business.entities.Order;
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

        if (orderId != null) {
            int orderIdInt = Integer.parseInt(orderId);
            List<Order> orderList = (List<Order>) session.getAttribute("orderList");

            //Shows SVG drawings for customers who has paid
            for (int i = 0; i < orderList.size(); i++) {
                if (orderList.get(i).getOrderId() == orderIdInt) {
                    order = orderList.get(i);
                    if (order.getStatus().equals("paid")) {
                        //creates SVG from the top of the carport
                        Carport carport = order.getCarport();
                        SVG svg = new SVG(0, 0, "0 0 1000 900", 150, 100, carport);
                        String svgCode = svg.generateSvgTop();
                        request.setAttribute("svgdrawing", svgCode);

                        //Create SVG from the side of the carport
                        SVG svgSide = new SVG(0, 0, "0 0 1000 900", 150, 100, carport);
                        String svgCodeSide = svgSide.generateSvgSide();
                        request.setAttribute("svgdrawingside", svgCodeSide);
                        request.setAttribute("bomByOrderId", order.getOrderId());
                        CalcCarport calcCarport = new CalcCarport();
                        carport = calcCarport.getCarportMaterials(carport, materialsFacade);
                        calcCarport.totalPrice(carport, order, materialsFacade);
                        session.setAttribute("carport", carport);
                    }
                    session.setAttribute("order", order);
                    return pageToShow;
                } else {
                    request.setAttribute("error", "Der er sket en fejl");
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
