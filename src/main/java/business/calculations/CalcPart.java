package business.calculations;

import business.entities.Shed;
import com.mysql.cj.xdevapi.UpdateStatementImpl;

public class CalcPart {
    final static int MAX_LENGTH_BETWEEN_POSTS = 310;

    public static int calcPostAmount(int carportLength, boolean hasShed) {//evt boolean med shed eller ej
        int amountOfPosts = 0;
        int remainingLength = carportLength-100-30; //distance between front and rear posts.
        if (hasShed){
            remainingLength = remainingLength-190;
            if (remainingLength<MAX_LENGTH_BETWEEN_POSTS || remainingLength==MAX_LENGTH_BETWEEN_POSTS ){
                amountOfPosts = 0;
            } else if (remainingLength<(MAX_LENGTH_BETWEEN_POSTS*2) && remainingLength>MAX_LENGTH_BETWEEN_POSTS || remainingLength==(MAX_LENGTH_BETWEEN_POSTS*2)){
                amountOfPosts = 1;
            }
            amountOfPosts = ((amountOfPosts + 3)*2)+3;
        } else {
            //100cm from front to first post
            //30 cm from the back of carport is where the post is located.
            if (remainingLength<MAX_LENGTH_BETWEEN_POSTS || remainingLength==MAX_LENGTH_BETWEEN_POSTS){
                amountOfPosts = 0;
            } else if (remainingLength<(MAX_LENGTH_BETWEEN_POSTS*2) && remainingLength>MAX_LENGTH_BETWEEN_POSTS || remainingLength==(MAX_LENGTH_BETWEEN_POSTS*2)){
                amountOfPosts = 1;
            } else if (remainingLength<(MAX_LENGTH_BETWEEN_POSTS*3) && remainingLength>(MAX_LENGTH_BETWEEN_POSTS*2) || remainingLength==(MAX_LENGTH_BETWEEN_POSTS*3)){
                amountOfPosts = 2;
            }
            amountOfPosts = (amountOfPosts+2) * 2; //calculating the posts needed for both sides and always 2 posts at the front and back of the carport.
        }


        return amountOfPosts;
    }

    public static int calcRafters(int carportLength, int spaceBetweenRafters) {//rafters = spær //spaceBetweenRafters is always 55(for now)
        //(Carport længde-10) / 55 +1 =  15
        int amount = 0;
        amount = (carportLength - 10) / spaceBetweenRafters + 1;
        return amount;
    }

    public static int calcRem(int carportLength, int remLength) {//rem engelsk?
        //TODO tjek
        int remAmount = ((carportLength * 2) / remLength) + 1;


        return remAmount;
    }

    public static int calcRoof(int carportLength, int carportWidth, int roofLength, int roofWidth) {
        int amount = ((carportLength / roofLength) + 1) * ((carportWidth / roofWidth) + 1);
        return amount;
    }


    public static int calcSubStarboardsBackAndFront(int carportWidth, int subStarboardBackAndFrontLength) {
        //((carportWidth+5)/subStarboardLength)*2+1; is the best for economical reasons,
        // but the following is beautiful and manageable;
        int amount = 0;
        if (carportWidth < subStarboardBackAndFrontLength || carportWidth == subStarboardBackAndFrontLength) {
            amount = 2;
        } else if (carportWidth > subStarboardBackAndFrontLength && carportWidth < (subStarboardBackAndFrontLength * 2) || carportWidth == (subStarboardBackAndFrontLength * 2)) {
            amount = 4;
        } else if (carportWidth > (subStarboardBackAndFrontLength * 2)) {
            amount = 6;
        }

        return amount;
    }

    public static int calcSubStarboardsSides(int carportLength, int subStarboardSidesLength) {
        //(carportLength/subStarboardLength)*2+1; is the best for economical reasons,
        // but the following is beautiful and manageable;
        int amount = 0;
        if (carportLength < subStarboardSidesLength || carportLength == subStarboardSidesLength) {
            amount = 2;
        } else if (carportLength > subStarboardSidesLength) {
            amount = 4;
        }

        return amount;
    }

    public static int calcOverSternFor(int carportWidth, int overSternForLength) {
        //((carportWidth+5)/overSternForLength)*2+1; is the best for economical reasons,
        // but the following is beautiful and manageable;
        int amount = 0;
        if (carportWidth < overSternForLength || carportWidth == overSternForLength) {
            amount = 1;
        } else if (carportWidth > overSternForLength && carportWidth < (overSternForLength * 2) || carportWidth == (overSternForLength * 2)) {
            amount = 2;
        } else if (carportWidth > (overSternForLength * 2)) {
            amount = 3;
        }

        return amount;
    }

    public static int calcOverSternSider(int carportLength, int overSternSiderLength) {
        //(carportLength/OverSternSiderLength)*2+1; is the best for economical reasons,
        // but the following is beautiful and manageable;
        int amount = 0;
        if (carportLength < overSternSiderLength || carportLength == overSternSiderLength) {
            amount = 2;
        } else if (carportLength > overSternSiderLength) {
            amount = 4;
        }
        return amount;

    }

    public static int calcVandBrædtSider(int carportLength, int vandBrædtSiderLength) {
        //(carportLength/vandBrædtSiderLength)*2+1; is the best for economical reasons,
        // but the following is beautiful and manageable;
        int amount = 0;
        if (carportLength < vandBrædtSiderLength || carportLength == vandBrædtSiderLength) {
            amount = 2;
        } else if (carportLength > vandBrædtSiderLength) {
            amount = 4;
        }
        return amount;
    }

    public static int calcVandBrædtFront(int carportWidth, int vandBrædtFrontLength) {
        //((carportWidth+5)/overSternForLength)+1; is the best for economical reasons,
        // but the following is beautiful and manageable;
        int amount = 0;
        if (carportWidth < vandBrædtFrontLength || carportWidth == vandBrædtFrontLength) {
            amount = 1;
        } else if (carportWidth > vandBrædtFrontLength && carportWidth < (vandBrædtFrontLength * 2) || carportWidth == (vandBrædtFrontLength * 2)) {
            amount = 2;
        } else if (carportWidth > (vandBrædtFrontLength * 2)) {
            amount = 3;
        }

        return amount;
    }

    public static int calcPlastmoScrew(int roofAmount) {
        int amount = 0;
        if (roofAmount < 4 || roofAmount == 4) {
            amount = 1;
        } else if (roofAmount > 4 && roofAmount < 8 || roofAmount == 8) {
            amount = 2;
        } else if (roofAmount > 8 && roofAmount < 12 || roofAmount == 12) {
            amount = 3;
        } else if (roofAmount > 12 && roofAmount < 16 || roofAmount == 16) {
            amount = 4;
        } else if (roofAmount > 16 && roofAmount < 20 || roofAmount == 20) {
            amount = 5;
        }
        return amount;
    }

    public static int calcPerforatedTape() {
        return 2;
    }

    public static int calcUniversalFittingsRight(int amountOfRafters) {
        return amountOfRafters;
    }

    public static int calcUniversalFittingsLeft(int amountOfRafters) {
        return amountOfRafters;
    }

    public static int calcScrews60mm() {
        return 1;
    }

    public static int calcFittingScrews(int universalFittingsRight, int universalFittingsLeft) {
        int amount = 0;
        amount = ((((universalFittingsRight + universalFittingsLeft) * 3 * 3) / 250) + 1) + 1;

        return amount;
    }

    public static int calcCarriageBolt(int posts) {
        int amount = 0;
        amount = posts * 2;

        return amount;
    }

    public static int calcSquareWasher(int posts) {
        int amount = 0;
        amount = posts + 1;
        return amount;
    }

    public static int calcScrews70mm(boolean hasShed) {
        int amount = 0;
        if (hasShed == true){ amount = 2; }
        else if (hasShed == false){ amount = 0; }
        return amount;
    }

    public static int calcScrews50mm(boolean hasShed) {
        int amount = 0;
        if (hasShed == true){ amount = 2; }
        else if (hasShed == false){ amount = 0; }
        return amount;
    }

    public static int calcZDoor(boolean hasShed){
        int amount = 0;
        if (hasShed == true){ amount = 1; }
        else if (hasShed == false){ amount = 0; }
        return amount;
    }

    public static int calcLockDoor(boolean hasShed){
        int amount = 0;
        if (hasShed == true){ amount = 1; }
        else if (hasShed == false){ amount = 0; }
        return amount;
    }
    public static int calcHinge(boolean hasShed){
        int amount = 0;
        if (hasShed == true){ amount = 2; }
        else if (hasShed == false){ amount = 0; }
        return amount;
    }
    public static int calcSheating(boolean hasShed, Shed shed){
        int amount = 0;
        double circumference = 0;
        if (hasShed == true){
            float shedLength = shed.getShedLength()/100;
            float shedWidth = shed.getShedWidth()/100;
            circumference = (shedWidth+shedLength)*2;
            amount = (int) ((circumference * (138.4/100))+1)*10;

        } else if (hasShed == false){ amount = 0; }

        return amount;
    }
    public static int calcNoggingPieceGable(boolean hasShed, Shed shed, int materialLength){
        int amount = 0;
        if (hasShed == true){

        amount = (((shed.getShedLength()*2)/materialLength)*3)+1;

        } else if (hasShed == false){ amount = 0; }
        return amount;
    }

    public static int calcNoggingPieceSides(boolean hasShed){
        int amount = 0;
        if (hasShed == true){ amount = 4; }
        else if (hasShed == false){ amount = 0; }
        return amount;
    }

    public static int calcAngleFitting(boolean hasShed,int amountNoggingPiece){
        int amount = 0;
        if (hasShed == true){ amount = amountNoggingPiece*2; }
        else if (hasShed == false){ amount = 0; }
        return amount;
    }

}
