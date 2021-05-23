package web.commands.admin;

import business.entities.Carport;
import business.entities.Order;
import business.exceptions.UserException;
import web.commands.CommandProtectedPage;

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
        session.setAttribute("salesprice", salesPrice);
        Carport carport = (Carport) session.getAttribute("carport");
        Order order = (Order) session.getAttribute("order");
        double costPrice = carport.getCostPrice();

        double salesPriceDouble = Double.parseDouble(salesPrice);

//(5629,5-4050)/4050*100
        double contributionRatio = (salesPriceDouble - costPrice) / costPrice * 100;//procent
//double contributionRatio = (costPrice/salesPriceDouble)*100;//procent
        NumberFormat formatter = new DecimalFormat("#0.00");
        session.setAttribute("contributionRatio", formatter.format(contributionRatio));

        //String salesPrice = session.("salesprice");

        return pageToShow; //adminorder
    }
}
