package web.commands;

import business.calculations.CalcPart;
import business.entities.DeliveryInfo;
import business.entities.Material;
import business.entities.Order;
import business.exceptions.UserException;
import business.persistence.Database;
import business.services.DeliveryInfoFacade;
import business.services.MaterialsFacade;
import business.services.OrderFacade;
import com.sun.tools.corba.se.idl.constExpr.Or;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class ShowOrderDetailsCommand extends CommandProtectedPage {
    private OrderFacade orderFacade;
    private MaterialsFacade materialsFacade;

    public ShowOrderDetailsCommand(String pageToShow, String role) {
        super(pageToShow, role);
        orderFacade = new OrderFacade(database);
        materialsFacade = new MaterialsFacade(database);
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();
        String orderId = request.getParameter("customerorder");
        Order order = null;
        int orderIdInt = 0;
        try {
            orderIdInt = Integer.parseInt(orderId);

        } catch (NumberFormatException e) {
            throw new UserException(e.getMessage());
        }
        order = orderFacade.getOrderById(orderIdInt);
        session.setAttribute("order", order);
        int carportLength = order.getCarport().getCarportLength();
        int carportWidth = order.getCarport().getCarportWidth();
        double totalPrice = 0;

        for (Material thisMaterial : materialsFacade.getAllMaterials()) {
            if (thisMaterial.getMaterialId() == 4) {
                thisMaterial.setAmount(CalcPart.calcSubStarboardsBackAndFront(order.getCarport().getCarportWidth(), thisMaterial.getLength()));
                totalPrice = totalPrice + (thisMaterial.getPrice()* thisMaterial.getAmount());
            } else if (thisMaterial.getMaterialId() == 5) {
                thisMaterial.setAmount(CalcPart.calcSubStarboardsSides(carportLength, thisMaterial.getLength()));
                totalPrice = totalPrice + (thisMaterial.getPrice()* thisMaterial.getAmount());
            } else if (thisMaterial.getMaterialId() == 6) {
                thisMaterial.setAmount(CalcPart.calcOverSternFor(carportWidth, thisMaterial.getLength()));
                totalPrice = totalPrice + (thisMaterial.getPrice()* thisMaterial.getAmount());
            } else if (thisMaterial.getMaterialId() == 7) {
                thisMaterial.setAmount(CalcPart.calcOverSternSider(carportLength, thisMaterial.getLength()));
                totalPrice = totalPrice + (thisMaterial.getPrice()* thisMaterial.getAmount());
            } else if (thisMaterial.getMaterialId() == 8) {
                thisMaterial.setAmount(0);//ikke oprettet
                totalPrice = totalPrice + (thisMaterial.getPrice()* thisMaterial.getAmount());
            } else if (thisMaterial.getMaterialId() == 9) {
                thisMaterial.setAmount(0);//ikke oprettet
                totalPrice = totalPrice + (thisMaterial.getPrice()* thisMaterial.getAmount());
            } else if (thisMaterial.getMaterialId() == 10) {
                thisMaterial.setAmount(0);//ikke oprettet
                totalPrice = totalPrice + (thisMaterial.getPrice()* thisMaterial.getAmount());
            } else if (thisMaterial.getMaterialId() == 11) {
                thisMaterial.setAmount(CalcPart.calcRem(carportLength,thisMaterial.getLength()));
                totalPrice = totalPrice + (thisMaterial.getPrice()* thisMaterial.getAmount());
            } else if (thisMaterial.getMaterialId() == 12) {
                thisMaterial.setAmount(0);//ikke oprettet
                totalPrice = totalPrice + (thisMaterial.getPrice()* thisMaterial.getAmount());
            } else if (thisMaterial.getMaterialId() == 13) {
                thisMaterial.setAmount(CalcPart.calcRafters(carportLength,55));
                totalPrice = totalPrice + (thisMaterial.getPrice()* thisMaterial.getAmount());
            } else if (thisMaterial.getMaterialId() == 14) {
                thisMaterial.setAmount(CalcPart.calcPostAmount(carportLength));
                totalPrice = totalPrice + (thisMaterial.getPrice()* thisMaterial.getAmount());
            } else if (thisMaterial.getMaterialId() == 15) {
                thisMaterial.setAmount(0);//ikke oprettet
            } else if (thisMaterial.getMaterialId() == 16) {
                thisMaterial.setAmount(CalcPart.calcVandBrædtSider(carportLength,thisMaterial.getLength()));
                totalPrice = totalPrice + (thisMaterial.getPrice()* thisMaterial.getAmount());
            }else if(thisMaterial.getMaterialId()==17){
                thisMaterial.setAmount(CalcPart.calcVandBrædtFront(carportWidth,thisMaterial.getLength()));
                totalPrice = totalPrice + (thisMaterial.getPrice()* thisMaterial.getAmount());
            } else if(thisMaterial.getMaterialId()==18){
                thisMaterial.setAmount(CalcPart.calcRoof(carportLength,carportWidth,thisMaterial.getLength(),thisMaterial.getWidth()));
                totalPrice = totalPrice + (thisMaterial.getPrice()* thisMaterial.getAmount());
            }

        }
        System.out.println(totalPrice);


        return pageToShow;
    }
}
