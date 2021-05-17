package web.commands;

import business.entities.DeliveryInfo;
import business.entities.Material;
import business.entities.Order;
import business.exceptions.UserException;
import business.persistence.Database;
import business.services.DeliveryInfoFacade;
import business.services.OrderFacade;
import com.sun.tools.corba.se.idl.constExpr.Or;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class ShowOrderDetailsCommand extends CommandProtectedPage {
    private OrderFacade orderFacade;
    public ShowOrderDetailsCommand(String pageToShow, String role) {
        super(pageToShow, role);
        orderFacade = new OrderFacade(database);
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();
        String orderId = request.getParameter("customerorder");
        Order order = null;
        int orderIdInt = 0;
        try {
            orderIdInt = Integer.parseInt(orderId);

        }catch(NumberFormatException e){
          throw new UserException(e.getMessage());
        }
        order = orderFacade.getOrderById(orderIdInt);
        session.setAttribute("order",order);
        return pageToShow;
    }
}
