package web.commands;

import business.entities.Order;
import business.exceptions.UserException;
import business.persistence.OrderMapper;
import business.services.DeliveryInfoFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class GetOrdersCommand extends CommandProtectedPage {
    private OrderMapper orderMapper;
    private DeliveryInfoFacade deliveryInfoFacade;

    public GetOrdersCommand(String pageToShow, String role) {
        super(pageToShow, role);
        orderMapper = new OrderMapper(database);
        deliveryInfoFacade = new DeliveryInfoFacade(database);

    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();
        List<Order> orderList = orderMapper.getAllOrders();
        List<Order> sortedList = new ArrayList<>();
        String email = null;
        for (Order thisOrder : orderList) {
            email = deliveryInfoFacade.getCustomerEmail(thisOrder.getDeliveryInfoId());
            thisOrder.setEmail(email);
        }
        int maxLength = orderList.size();
        request.setAttribute("sortedList", orderList);
        String sortBy = request.getParameter("sortBy");
        if (sortBy != null) {

            if (sortBy.equals("all orders")) {
                request.setAttribute("sortedList", orderList);
            }

//test
            if (sortBy.equals("request")) {
                for (int i = 0; i < maxLength; i++) {
                    if (orderList.get(i).getStatus().equals("request")) {
                        sortedList.add(orderList.get(i));
                        request.setAttribute("sortedList", sortedList);
                    }
                }
            }
            if (sortBy.equals("offer sent")) {
                for (int i = 0; i < maxLength; i++) {
                    if (orderList.get(i).getStatus().equals("offer sent")) {
                        sortedList.add(orderList.get(i));
                        request.setAttribute("sortedList", sortedList);
                    }
                }
            }

            if (sortBy.equals("accepted")) {
                for (int i = 0; i < orderList.size(); i++) {
                    if (orderList.get(i).getStatus().equals("accepted")) {
                        sortedList.add(orderList.get(i));
                        request.setAttribute("sortedList", sortedList);
                    }
                }
            }
            if (sortBy.equals("paid")) {
                for (int i = 0; i < orderList.size(); i++) {
                    if (orderList.get(i).getStatus().equals("paid")) {
                        sortedList.add(orderList.get(i));
                        request.setAttribute("sortedList", sortedList);
                    }
                }
            }
            if (sortBy.equals("declined")) {
                for (int i = 0; i < orderList.size(); i++) {
                    if (orderList.get(i).getStatus().equals("declined")) {
                        sortedList.add(orderList.get(i));
                        request.setAttribute("sortedList", sortedList);
                    }
                }
            }
            if (sortBy.equals("finished")) {
                for (int i = 0; i < orderList.size(); i++) {
                    if (orderList.get(i).getStatus().equals("finished")) {
                        sortedList.add(orderList.get(i));
                        request.setAttribute("sortedList", sortedList);
                    }
                }
            }
        }


        return pageToShow;
    }
}
