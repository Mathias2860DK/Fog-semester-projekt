package web.commands;

import business.entities.Order;
import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class UpdatePriceCommand extends CommandProtectedPage {
    public UpdatePriceCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();
        String salesPrice = request.getParameter("salesprice");
session.setAttribute("salesprice",salesPrice);
        Order order = (Order) session.getAttribute("order");
        double costPrice = order.getTotalprice();

double salesPriceDouble = Double.parseDouble(salesPrice);
double contributionRatio = (salesPriceDouble/costPrice)*10;//procent
        NumberFormat formatter = new DecimalFormat("#0.00");
session.setAttribute("contributionRatio", formatter.format(contributionRatio));

        //String salesPrice = session.("salesprice");

        return pageToShow; //adminorder
    }
}
