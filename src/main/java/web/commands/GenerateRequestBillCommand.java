package web.commands;

import business.entities.DeliveryInfo;
import business.entities.User;
import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GenerateRequestBillCommand extends CommandUnprotectedPage {

    public GenerateRequestBillCommand(String pageToShow) {
        super(pageToShow);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();
        DeliveryInfo deliveryInfo = null;

        User user = null;
        int userId = 0;

        if (session.getAttribute("user") != null) {
            user = (User) session.getAttribute("user");
            userId = user.getId();
        } else {
            userId = 1;
        }

        String name = request.getParameter("name");
        String adress = request.getParameter("adress");
        String zipCodeCity = request.getParameter("zip_code_city");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String remarks = request.getParameter("remarks");
        deliveryInfo = new DeliveryInfo(userId, name, adress, zipCodeCity, Integer.parseInt(phone), email, remarks);

        session.setAttribute("deliveryInfo", deliveryInfo);
        return pageToShow;
    }
}
