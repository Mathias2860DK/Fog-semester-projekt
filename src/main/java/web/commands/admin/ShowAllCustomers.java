package web.commands.admin;

import business.entities.DeliveryInfo;
import business.exceptions.UserException;
import business.services.DeliveryInfoFacade;
import web.commands.CommandProtectedPage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class ShowAllCustomers extends CommandProtectedPage {
    DeliveryInfoFacade deliveryInfoFacade;

    public ShowAllCustomers(String pageToShow, String role) {
        super(pageToShow, role);
        deliveryInfoFacade = new DeliveryInfoFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        List<DeliveryInfo> getAllCustomers = new ArrayList<>();
        getAllCustomers = deliveryInfoFacade.getAllCustomers();
        request.setAttribute("getAllCustomers", getAllCustomers);
        return pageToShow;
    }
}
