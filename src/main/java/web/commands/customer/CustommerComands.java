package web.commands.customer;

import business.entities.Order;
import business.entities.User;
import business.exceptions.UserException;
import business.persistence.OrderMapper;
import business.services.DeliveryInfoFacade;
import web.commands.CommandProtectedPage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class CustommerComands extends CommandProtectedPage {
    private DeliveryInfoFacade deliveryInfoFacade;
    private OrderMapper orderMapper;

    public CustommerComands(String pageToShow, String role) {
        super(pageToShow, role);
        deliveryInfoFacade = new DeliveryInfoFacade(database);
        orderMapper = new OrderMapper(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();
        User user = null;
        int userId = 0;

        if (session.getAttribute("user") != null) {
            user = (User) session.getAttribute("user");
            userId = user.getId();
        } else {
            //Client should not be able to access this site without being logged in
            request.setAttribute("error", "Kontakt IT. Der er sket en fejl");
        }
//TODO: Lav en fleksibel procedure der kan læse et udifineret antal af delivery_info_id og vise alle ordre med disse delivery_info_id
        //SELECT * FROM fog.orders where delivery_info_id = (Udetfineret tal, da det kommer an på hvor mange delivery_info_id der er;
        List<Order> orderList = new ArrayList<>();


        List<Integer> deliveryInfoIdByUserList = deliveryInfoFacade.getDeliveryInfoIdByUserId(userId);
        int length = deliveryInfoIdByUserList.size();

//Runs through all orders with the specified user's delivery_info_id's
        for (int i = 0; i < length; i++) {
            orderList.add(orderMapper.getOrdersByDeliveryInfoId(deliveryInfoIdByUserList.get(i)));
        }

        session.setAttribute("orderList", orderList);

        return pageToShow;
    }
}
