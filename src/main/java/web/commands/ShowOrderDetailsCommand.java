package web.commands;

import business.calculations.CalcCarport;
import business.calculations.CalcPart;
import business.entities.Carport;
import business.entities.DeliveryInfo;
import business.entities.Material;
import business.entities.Order;
import business.exceptions.UserException;
import business.persistence.Database;
import business.services.DeliveryInfoFacade;
import business.services.MaterialsFacade;
import business.services.OrderFacade;
import com.sun.tools.corba.se.idl.constExpr.Or;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class ShowOrderDetailsCommand extends CommandProtectedPage {
    private OrderFacade orderFacade;
    private MaterialsFacade materialsFacade;
    private DeliveryInfoFacade deliveryInfoFacade;
    private CalcCarport calcCarport = new CalcCarport();
    double totalPrice = 0;

    public ShowOrderDetailsCommand(String pageToShow, String role) {
        super(pageToShow, role);
        orderFacade = new OrderFacade(database);
        materialsFacade = new MaterialsFacade(database);
        deliveryInfoFacade = new DeliveryInfoFacade(database);
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();
        String orderId = request.getParameter("customerorder");
        Order order = null;
        Carport carport = null;
        int orderIdInt = 0;
        String email = null;
        try {
            orderIdInt = Integer.parseInt(orderId);

        } catch (NumberFormatException e) {
            throw new UserException(e.getMessage());
        }
        order = orderFacade.getOrderById(orderIdInt);
        carport = new Carport(order.getCarport().getCarportWidth(), order.getCarport().getCarportWidth(), "");
        totalPrice = calcCarport.totalPrice(carport, order, materialsFacade);
        email = deliveryInfoFacade.getCustomerEmail(order.getDeliveryInfoId());
        order.setEmail(email);
        session.setAttribute("carport", carport);
        session.setAttribute("order", order);
        return pageToShow;
    }
}
