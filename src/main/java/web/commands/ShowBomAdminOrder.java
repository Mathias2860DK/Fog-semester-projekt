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
        String orderId = request.getParameter("bomByOrderId");
        request.setAttribute("bomByOrderId", orderId); //Check if it null on jsp page. If not --> display on jsp page
        int orderIdInt = Integer.parseInt(orderId);
        order = orderFacade.getOrderById(orderIdInt);
        carport = order.getCarport();
        CalcCarport calcCarport = new CalcCarport();
        carport = calcCarport.getCarportWithMaterials(carport, materialsFacade);
        calcCarport.totalPrice(carport, order, materialsFacade);
        session.setAttribute("carport", carport);


        return pageToShow;
    }
}
