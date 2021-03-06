package web.commands;

import business.entities.Carport;
import business.entities.DeliveryInfo;
import business.entities.Order;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.DeliveryInfoMapper;
import business.persistence.OrderMapper;
import business.services.DeliveryInfoFacade;
import business.services.OrderFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.sql.Timestamp;
import java.util.List;

public class SendRequestCommand extends CommandUnprotectedPage { //TODO: EVT burde man lave det til en Protected da det er kundens // oplysninger man håndterer
    private DeliveryInfoFacade deliveryInfoFacade;
    private OrderFacade orderFacade;

    public SendRequestCommand(String pageToShow) {
        super(pageToShow);
        orderFacade = new OrderFacade(database);
        deliveryInfoFacade = new DeliveryInfoFacade(database);

    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();

        DeliveryInfo deliveryInfo = (DeliveryInfo) session.getAttribute("deliveryInfo");
        Carport carport = (Carport) session.getAttribute("carport");

        int deliveryInfoId = deliveryInfoFacade.insertDeliveryInfo(deliveryInfo);

        Order order = new Order(deliveryInfoId, carport, new Timestamp(System.currentTimeMillis()), "request", 0);
        int orderId = orderFacade.insertOrder(order, deliveryInfoId);
        order.setOrderId(orderId);
        session.setAttribute("order", order);


        return pageToShow;
    }
}
