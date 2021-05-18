package web.commands;

import business.calculations.CalcCarport;
import business.entities.Carport;
import business.entities.Order;
import business.exceptions.UserException;
import business.services.MaterialsFacade;
import business.services.OrderFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowBomAdminOrder extends CommandProtectedPage {
private OrderFacade orderFacade;
private MaterialsFacade materialsFacade;
    public ShowBomAdminOrder(String pageToShow, String role) {
        super(pageToShow, role);
        this.orderFacade = new OrderFacade(database);
        this.materialsFacade = new MaterialsFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        Order order = null;
        Carport carport = null;
        HttpSession session = request.getSession();
        int orderId = (int) session.getAttribute("bomByOrderId");
        order = orderFacade.getOrderById(orderId);
        carport = order.getCarport();
        CalcCarport calcCarport = new CalcCarport();
        calcCarport.totalPrice(carport,order,materialsFacade);


        return pageToShow;
    }
}
