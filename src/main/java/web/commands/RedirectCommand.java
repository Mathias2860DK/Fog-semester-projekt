package web.commands;

import business.entities.DeliveryInfo;
import business.entities.User;
import business.exceptions.UserException;
import business.services.DeliveryInfoFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RedirectCommand extends CommandUnprotectedPage {
    private DeliveryInfoFacade deliveryInfoFacade;
    public RedirectCommand(String pageToShow) {
        super(pageToShow);
        this.deliveryInfoFacade = new DeliveryInfoFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        //only purpose of this Command class is to redirect to the correct page.

        HttpSession session = request.getSession();
        User user = null;
        int userId = 0;

        //Checks if users latest delivery information.
        if (session.getAttribute("user") != null) {
            user = (User) session.getAttribute("user");
            userId = user.getId();
            session.setAttribute("oldDelivery","Vi har gemt nogle gamle leveringsoplysninger. Vil du bruge de samme?");
DeliveryInfo deliveryInfo = deliveryInfoFacade.getLatestDeliveryInfoByUserId(userId);
session.setAttribute("deliveryInfo",deliveryInfo);

        }

        String carportdesign = request.getParameter("designcarport");
        if (carportdesign != null) {
            return "designcarport";
        }
        return pageToShow;
    }
}
