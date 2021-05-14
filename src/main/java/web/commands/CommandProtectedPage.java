package web.commands;

import business.entities.Order;
import business.exceptions.UserException;
import business.persistence.OrderMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CommandProtectedPage extends Command {
    public String role;
    public String pageToShow;
    private OrderMapper orderMapper;

    public CommandProtectedPage(String pageToShow, String role) {
        this.pageToShow = pageToShow;
        this.role = role;
        orderMapper = new OrderMapper(database);

    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {//TODO: Pak væk
        List<Order> orderList = orderMapper.getAllOrders();
        String sortBy = request.getParameter("sortBy");
        if (sortBy.equals("all orders")){
            for (int i = 0; i < orderList.size(); i++){
                    orderList.add(orderList.get(i));
                    request.setAttribute("orderList", orderList);
            }
        }

        if (sortBy.equals("request")) {
            for (int i = 0; i < orderList.size(); i++) {
                if (orderList.get(i).getStatus().equals("request")) {
                    orderList.add(orderList.get(i));
                    request.setAttribute("orderList", orderList);
                }
            }
        }
        if (sortBy.equals("offer sent")) {
            for (int i = 0; i < orderList.size(); i++) {
                if (orderList.get(i).getStatus().equals("offer sent")) {
                    orderList.add(orderList.get(i));
                    request.setAttribute("orderList", orderList);
                }
            }
        }

        if (sortBy.equals("accepted")) {
            for (int i = 0; i < orderList.size(); i++) {
                if (orderList.get(i).getStatus().equals("accepted")) {
                    orderList.add(orderList.get(i));
                    request.setAttribute("orderList", orderList);
                }
            }
        }
        if (sortBy.equals("paid")) {
            for (int i = 0; i < orderList.size(); i++) {
                if (orderList.get(i).getStatus().equals("paid")) {
                    orderList.add(orderList.get(i));
                    request.setAttribute("orderList", orderList);
                }
            }
        }
        if (sortBy.equals("declined")) {
            for (int i = 0; i < orderList.size(); i++) {
                if (orderList.get(i).getStatus().equals("declined")) {
                    orderList.add(orderList.get(i));
                    request.setAttribute("orderList", orderList);
                }
            }
        }
        if (sortBy.equals("finished")) {
            for (int i = 0; i < orderList.size(); i++) {
                if (orderList.get(i).getStatus().equals("finished")) {
                    orderList.add(orderList.get(i));
                    request.setAttribute("orderList", orderList);
                }
            }
        }
        return pageToShow;
    }

    public String getRole() {
        return role;
    }
}
