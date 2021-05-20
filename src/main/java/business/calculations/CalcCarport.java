package business.calculations;

import business.entities.*;
import business.exceptions.UserException;
import business.services.MaterialsFacade;

import java.util.ArrayList;
import java.util.List;

public class CalcCarport {
    public double totalPrice(Carport carport, Order order, MaterialsFacade materialsFacade) throws UserException {
        int carportLength = order.getCarport().getCarportLength();
        int carportWidth = order.getCarport().getCarportWidth();
        double totalPrice = 0;
        int roofLength = 0;
        int roofWidth = 0;
        int amountOfUniversalFittingsRight = 0;
        int amountOfUniversalFittingsLeft = 0;
        int amountOfNogginPiece = 0;
        boolean hasShed = false;
        Shed shed = order.getCarport().getShed();
        if(shed.getShedWidth() == 0) {
            hasShed = false;
        } else {
            hasShed = true;
        }


        for (Material thisMaterial : materialsFacade.getAllMaterials()) {

            if (thisMaterial.getMaterialId() == 4) {
                thisMaterial.setAmount(CalcPart.calcSubStarboardsBackAndFront(carportWidth, thisMaterial.getLength()));
                totalPrice = totalPrice + (thisMaterial.getPrice() * thisMaterial.getAmount());

            } else if (thisMaterial.getMaterialId() == 5) {
                thisMaterial.setAmount(CalcPart.calcSubStarboardsSides(carportLength, thisMaterial.getLength()));
                totalPrice = totalPrice + (thisMaterial.getPrice() * thisMaterial.getAmount());

            } else if (thisMaterial.getMaterialId() == 6) {
                thisMaterial.setAmount(CalcPart.calcOverSternFor(carportWidth, thisMaterial.getLength()));
                totalPrice = totalPrice + (thisMaterial.getPrice() * thisMaterial.getAmount());

            } else if (thisMaterial.getMaterialId() == 7) {
                thisMaterial.setAmount(CalcPart.calcOverSternSider(carportLength, thisMaterial.getLength()));
                totalPrice = totalPrice + (thisMaterial.getPrice() * thisMaterial.getAmount());

            } else if (thisMaterial.getMaterialId() == 8) {
                thisMaterial.setAmount(CalcPart.calcZDoor(hasShed));
                totalPrice = totalPrice + (thisMaterial.getPrice() * thisMaterial.getAmount());

            } else if (thisMaterial.getMaterialId() == 9) {
                thisMaterial.setAmount(CalcPart.calcNoggingPieceGable(hasShed, shed,thisMaterial.getLength()));
                amountOfNogginPiece = amountOfNogginPiece + thisMaterial.getAmount();
                totalPrice = totalPrice + (thisMaterial.getPrice() * thisMaterial.getAmount());

            } else if (thisMaterial.getMaterialId() == 10) {
                thisMaterial.setAmount(CalcPart.calcNoggingPieceSides(hasShed));
                amountOfNogginPiece = amountOfNogginPiece + thisMaterial.getAmount();
                totalPrice = totalPrice + (thisMaterial.getPrice() * thisMaterial.getAmount());

            } else if (thisMaterial.getMaterialId() == 11) {
                thisMaterial.setAmount(CalcPart.calcRem(carportLength, thisMaterial.getLength()));
                totalPrice = totalPrice + (thisMaterial.getPrice() * thisMaterial.getAmount());

            } else if (thisMaterial.getMaterialId() == 12) {
                thisMaterial.setAmount(0);//ikke oprettet
                totalPrice = totalPrice + (thisMaterial.getPrice() * thisMaterial.getAmount());

            } else if (thisMaterial.getMaterialId() == 13) {
                thisMaterial.setAmount(CalcPart.calcRafters(carportLength, 55));
                totalPrice = totalPrice + (thisMaterial.getPrice() * thisMaterial.getAmount());

            } else if (thisMaterial.getMaterialId() == 14) {
                thisMaterial.setAmount(CalcPart.calcPostAmount(carportLength));
                totalPrice = totalPrice + (thisMaterial.getPrice() * thisMaterial.getAmount());

            } else if (thisMaterial.getMaterialId() == 15) {
                thisMaterial.setAmount(CalcPart.calcSheating(hasShed, shed));
                totalPrice = totalPrice + (thisMaterial.getPrice() * thisMaterial.getAmount());

            } else if (thisMaterial.getMaterialId() == 16) {
                thisMaterial.setAmount(CalcPart.calcVandBrædtSider(carportLength, thisMaterial.getLength()));
                totalPrice = totalPrice + (thisMaterial.getPrice() * thisMaterial.getAmount());

            } else if (thisMaterial.getMaterialId() == 17) {
                thisMaterial.setAmount(CalcPart.calcVandBrædtFront(carportWidth, thisMaterial.getLength()));
                totalPrice = totalPrice + (thisMaterial.getPrice() * thisMaterial.getAmount());

            } else if (thisMaterial.getMaterialId() == 18) {
                roofLength = thisMaterial.getLength();
                roofWidth = thisMaterial.getWidth();
                thisMaterial.setAmount(CalcPart.calcRoof(carportLength, carportWidth, roofLength, roofWidth));
                totalPrice = totalPrice + (thisMaterial.getPrice() * thisMaterial.getAmount());

            } else if (thisMaterial.getMaterialId() == 19) {
                thisMaterial.setAmount(CalcPart.calcPlastmoScrew(CalcPart.calcRoof(carportLength, carportWidth, roofLength, roofWidth)));
                totalPrice = totalPrice + (thisMaterial.getPrice() * thisMaterial.getAmount());

            } else if (thisMaterial.getMaterialId() == 20) {
                thisMaterial.setAmount(CalcPart.calcPerforatedTape());
                totalPrice = totalPrice + (thisMaterial.getPrice() * thisMaterial.getAmount());

            } else if (thisMaterial.getMaterialId() == 21) {
                amountOfUniversalFittingsRight = CalcPart.calcUniversalFittingsRight(CalcPart.calcRafters(carportLength, 55));
                thisMaterial.setAmount(amountOfUniversalFittingsRight);
                totalPrice = totalPrice + (thisMaterial.getPrice() * thisMaterial.getAmount());

            } else if (thisMaterial.getMaterialId() == 22) {
                amountOfUniversalFittingsLeft = CalcPart.calcUniversalFittingsLeft(CalcPart.calcRafters(carportLength, 55));
                thisMaterial.setAmount(amountOfUniversalFittingsLeft);
                totalPrice = totalPrice + (thisMaterial.getPrice() * thisMaterial.getAmount());

            } else if (thisMaterial.getMaterialId() == 23) {
                thisMaterial.setAmount(CalcPart.calcScrews60mm());
                totalPrice = totalPrice + (thisMaterial.getPrice() * thisMaterial.getAmount());

            } else if (thisMaterial.getMaterialId() == 24) {
                thisMaterial.setAmount(CalcPart.calcFittingScrews(amountOfUniversalFittingsRight, amountOfUniversalFittingsLeft));
                totalPrice = totalPrice + (thisMaterial.getPrice() * thisMaterial.getAmount());

            } else if (thisMaterial.getMaterialId() == 25) {
                thisMaterial.setAmount(CalcPart.calcCarriageBolt(CalcPart.calcPostAmount(carportLength)));
                totalPrice = totalPrice + (thisMaterial.getPrice() * thisMaterial.getAmount());

            } else if (thisMaterial.getMaterialId() == 26) {
                thisMaterial.setAmount(CalcPart.calcSquareWasher(CalcPart.calcPostAmount(carportLength)));
                totalPrice = totalPrice + (thisMaterial.getPrice() * thisMaterial.getAmount());

            } else if (thisMaterial.getMaterialId() == 27) {
                thisMaterial.setAmount(CalcPart.calcScrews70mm(hasShed));
                totalPrice = totalPrice + (thisMaterial.getPrice() * thisMaterial.getAmount());

            } else if (thisMaterial.getMaterialId() == 28) {
                thisMaterial.setAmount(CalcPart.calcScrews50mm(hasShed));
                totalPrice = totalPrice + (thisMaterial.getPrice() * thisMaterial.getAmount());

            } else if (thisMaterial.getMaterialId() == 29) {
                thisMaterial.setAmount(CalcPart.calcLockDoor(hasShed));
                totalPrice = totalPrice + (thisMaterial.getPrice() * thisMaterial.getAmount());


            } else if (thisMaterial.getMaterialId() == 30) {
                thisMaterial.setAmount(CalcPart.calcHinge(hasShed));
                totalPrice = totalPrice + (thisMaterial.getPrice() * thisMaterial.getAmount());


            } else if (thisMaterial.getMaterialId() == 31) {
                thisMaterial.setAmount(CalcPart.calcAngleFitting(hasShed,amountOfNogginPiece));
                totalPrice = totalPrice + (thisMaterial.getPrice() * thisMaterial.getAmount());

            }

        }

        carport.setCostPrice(totalPrice);
        return totalPrice;
    }

    public Carport getCarportWithMaterials(Carport carport, MaterialsFacade materialsFacade) throws UserException {
        int carportLength = carport.getCarportLength();
        int carportWidth = carport.getCarportWidth();
        int roofLength = 0;
        int roofWidth = 0;
        int amountOfUniversalFittingsRight = 0;
        int amountOfUniversalFittingsLeft = 0;
        boolean hasShed = false;
        int amountOfNogginPiece = 0;
        if(carport.getShed().getShedWidth() == 0){ hasShed = false; }
        else { hasShed = true; }


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
                thisMaterial.setAmount(CalcPart.calcZDoor(hasShed));
                materialList.add(thisMaterial);

            } else if (thisMaterial.getMaterialId() == 9) {
                thisMaterial.setAmount(CalcPart.calcNoggingPieceGable(hasShed, carport.getShed(),thisMaterial.getLength()));
                amountOfNogginPiece = amountOfNogginPiece + thisMaterial.getAmount();
                materialList.add(thisMaterial);

            } else if (thisMaterial.getMaterialId() == 10) {
                thisMaterial.setAmount(CalcPart.calcNoggingPieceSides(hasShed));
                amountOfNogginPiece = amountOfNogginPiece + thisMaterial.getAmount();
                materialList.add(thisMaterial);

            } else if (thisMaterial.getMaterialId() == 11) {
                thisMaterial.setAmount(CalcPart.calcRem(carportLength, thisMaterial.getLength()));
                materialList.add(thisMaterial);

            } else if (thisMaterial.getMaterialId() == 12) {
                thisMaterial.setAmount(0);//ikke oprettet
                materialList.add(thisMaterial);

            } else if (thisMaterial.getMaterialId() == 13) {
                thisMaterial.setAmount(CalcPart.calcRafters(carportLength, 55));
                materialList.add(thisMaterial);

            } else if (thisMaterial.getMaterialId() == 14) {
                thisMaterial.setAmount(CalcPart.calcPostAmount(carportLength));
                materialList.add(thisMaterial);

            } else if (thisMaterial.getMaterialId() == 15) {
                thisMaterial.setAmount(CalcPart.calcSheating(hasShed,carport.getShed()));
                materialList.add(thisMaterial);

            } else if (thisMaterial.getMaterialId() == 16) {
                thisMaterial.setAmount(CalcPart.calcVandBrædtSider(carportLength, thisMaterial.getLength()));
                materialList.add(thisMaterial);

            } else if (thisMaterial.getMaterialId() == 17) {
                thisMaterial.setAmount(CalcPart.calcVandBrædtFront(carportWidth, thisMaterial.getLength()));
                materialList.add(thisMaterial);

            } else if (thisMaterial.getMaterialId() == 18) {
                roofLength = thisMaterial.getLength();
                roofWidth = thisMaterial.getWidth();
                thisMaterial.setAmount(CalcPart.calcRoof(carportLength, carportWidth, roofLength, roofWidth));
                materialList.add(thisMaterial);

            } else if (thisMaterial.getMaterialId() == 19) {
                thisMaterial.setAmount(CalcPart.calcPlastmoScrew(CalcPart.calcRoof(carportLength, carportWidth, roofLength, roofWidth)));
                materialList.add(thisMaterial);

            } else if (thisMaterial.getMaterialId() == 20) {
                thisMaterial.setAmount(CalcPart.calcPerforatedTape());
                materialList.add(thisMaterial);

            } else if (thisMaterial.getMaterialId() == 21) {
                amountOfUniversalFittingsRight = CalcPart.calcUniversalFittingsRight(CalcPart.calcRafters(carportLength, 55));
                thisMaterial.setAmount(amountOfUniversalFittingsRight);
                materialList.add(thisMaterial);

            } else if (thisMaterial.getMaterialId() == 22) {
                amountOfUniversalFittingsLeft = CalcPart.calcUniversalFittingsLeft(CalcPart.calcRafters(carportLength, 55));
                thisMaterial.setAmount(amountOfUniversalFittingsLeft);
                materialList.add(thisMaterial);

            } else if (thisMaterial.getMaterialId() == 23) {
                thisMaterial.setAmount(CalcPart.calcScrews60mm());
                materialList.add(thisMaterial);

            } else if (thisMaterial.getMaterialId() == 24) {
                thisMaterial.setAmount(CalcPart.calcFittingScrews(amountOfUniversalFittingsRight, amountOfUniversalFittingsLeft));
                materialList.add(thisMaterial);

            } else if (thisMaterial.getMaterialId() == 25) {
                thisMaterial.setAmount(CalcPart.calcCarriageBolt(CalcPart.calcPostAmount(carportLength)));
                materialList.add(thisMaterial);

            } else if (thisMaterial.getMaterialId() == 26) {
                thisMaterial.setAmount(CalcPart.calcSquareWasher(CalcPart.calcPostAmount(carportLength)));
                materialList.add(thisMaterial);

            } else if (thisMaterial.getMaterialId() == 27) {
                thisMaterial.setAmount(CalcPart.calcScrews70mm(hasShed));
                materialList.add(thisMaterial);

            } else if (thisMaterial.getMaterialId() == 28) {
                thisMaterial.setAmount(CalcPart.calcScrews50mm(hasShed));
                materialList.add(thisMaterial);

            } else if (thisMaterial.getMaterialId() == 29) {
                thisMaterial.setAmount(CalcPart.calcLockDoor(hasShed));
                materialList.add(thisMaterial);

            } else if (thisMaterial.getMaterialId() == 30) {
                thisMaterial.setAmount(CalcPart.calcHinge(hasShed));
                materialList.add(thisMaterial);

            } else if (thisMaterial.getMaterialId() == 31) {
                thisMaterial.setAmount(CalcPart.calcAngleFitting(hasShed,amountOfNogginPiece));
                materialList.add(thisMaterial);

            }
        }

        return carport;
    }
}
