package web.commands;

import business.entities.DeliveryInfo;
import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SendRequestCommand extends CommandUnprotectedPage{ //TODO: EVT burde man lave det til en Protected da det er kundens oplysninger man håndterer
    public SendRequestCommand(String pageToShow) {
        super(pageToShow);
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();
        session.getAttribute("deliveryInfo");
        return pageToShow;
    }
}
