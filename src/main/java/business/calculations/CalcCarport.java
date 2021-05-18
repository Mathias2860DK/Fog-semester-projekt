package business.calculations;

import business.entities.Bom;
import business.entities.Carport;
import business.entities.Material;
import business.entities.Order;
import business.exceptions.UserException;
import business.services.MaterialsFacade;

import java.util.ArrayList;
import java.util.List;

public class CalcCarport {
    public double totalPrice(Carport carport, Order order, MaterialsFacade materialsFacade) throws UserException {
        int carportLength = order.getCarport().getCarportLength();
        int carportWidth = order.getCarport().getCarportWidth();
        double totalPrice = 0;

        for (Material thisMaterial : materialsFacade.getAllMaterials()) {
            if (thisMaterial.getMaterialId() == 4) {
                thisMaterial.setAmount(CalcPart.calcSubStarboardsBackAndFront(carportWidth, thisMaterial.getLength()));
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

        carport.setCostPrice(totalPrice);
        return totalPrice;
    }

    public Carport getCarportWithMaterials(Carport carport, MaterialsFacade materialsFacade) throws UserException {
        int carportLength = carport.getCarportLength();
        int carportWidth = carport.getCarportWidth();


        List<Material> materialList = carport.getMaterialList();

        for (Material thisMaterial : materialsFacade.getAllMaterials()) {
            if (thisMaterial.getMaterialId() == 4) {
                thisMaterial.setAmount(CalcPart.calcSubStarboardsBackAndFront(carportWidth, thisMaterial.getLength()));
                materialList.add(thisMaterial);

            } else if (thisMaterial.getMaterialId() == 5) {
                thisMaterial.setAmount(CalcPart.calcSubStarboardsSides(carportLength, thisMaterial.getLength()));
                materialList.add(thisMaterial);
            } else if (thisMaterial.getMaterialId() == 6) {
                thisMaterial.setAmount(CalcPart.calcOverSternFor(carportWidth, thisMaterial.getLength()));
                materialList.add(thisMaterial);
            } else if (thisMaterial.getMaterialId() == 7) {
                thisMaterial.setAmount(CalcPart.calcOverSternSider(carportLength, thisMaterial.getLength()));
                materialList.add(thisMaterial);
            } else if (thisMaterial.getMaterialId() == 8) {
                thisMaterial.setAmount(0);//ikke oprettet
                materialList.add(thisMaterial);

            } else if (thisMaterial.getMaterialId() == 9) {
                thisMaterial.setAmount(0);//ikke oprettet
                materialList.add(thisMaterial);

            } else if (thisMaterial.getMaterialId() == 10) {
                thisMaterial.setAmount(0);//ikke oprettet
                materialList.add(thisMaterial);

            } else if (thisMaterial.getMaterialId() == 11) {
                thisMaterial.setAmount(CalcPart.calcRem(carportLength,thisMaterial.getLength()));
                materialList.add(thisMaterial);

            } else if (thisMaterial.getMaterialId() == 12) {
                thisMaterial.setAmount(0);//ikke oprettet
                materialList.add(thisMaterial);

            } else if (thisMaterial.getMaterialId() == 13) {
                thisMaterial.setAmount(CalcPart.calcRafters(carportLength,55));
                materialList.add(thisMaterial);

            } else if (thisMaterial.getMaterialId() == 14) {
                thisMaterial.setAmount(CalcPart.calcPostAmount(carportLength));
                materialList.add(thisMaterial);

            } else if (thisMaterial.getMaterialId() == 15) {
                thisMaterial.setAmount(0);//ikke oprettet
                materialList.add(thisMaterial);
            } else if (thisMaterial.getMaterialId() == 16) {
                thisMaterial.setAmount(CalcPart.calcVandBrædtSider(carportLength,thisMaterial.getLength()));
                materialList.add(thisMaterial);

            }else if(thisMaterial.getMaterialId()==17){
                thisMaterial.setAmount(CalcPart.calcVandBrædtFront(carportWidth,thisMaterial.getLength()));
                materialList.add(thisMaterial);

            } else if(thisMaterial.getMaterialId()==18){
                thisMaterial.setAmount(CalcPart.calcRoof(carportLength,carportWidth,thisMaterial.getLength(),thisMaterial.getWidth()));
                materialList.add(thisMaterial);

            }

        }


        return carport;
    }
}
