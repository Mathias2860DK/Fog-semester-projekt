package business.calculations;

public class CalcPart {
    final static int MAX_LENGTH_BETWEEN_POSTS = 310;
    public static int calcPostAmount(int carportLength){//evt boolean med shed eller ej
        //100cm from front to first post
        //30 cm from the back of carport is where the post is located.
        int distance = carportLength-100-30; //distance between front and rear posts.
        int amountOfPosts = distance/MAX_LENGTH_BETWEEN_POSTS;//int converts it downwards.
        amountOfPosts = amountOfPosts * 2; //calculating the posts needed for both sides
        amountOfPosts = amountOfPosts + 4; //always 2 posts at the front and back of the carport.
        //TODO: what if there is a shed?
        //if (isShedWanted == true) ....
return amountOfPosts;
    }

    public static int calcRafters(int carportLength, int spaceBetweenRafters){//rafters = spær //spaceBetweenRafters is always 55(for now)
        //(Carport længde-10) / 55 +1 =  15
        int amount = 0;
        amount = (carportLength-10)/spaceBetweenRafters+1;
return amount;
    }
    public static int calcRem(int carportLength,int remLength){//rem engelsk?
        //TODO tjek
        int remAmount = ((carportLength*2)/remLength)+1;


        return remAmount;
    }

    public static int calcRoof(int carportLength, int carportWidth, int roofLength, int roofWidth){
        int amount = ((carportLength/roofLength)+1)*((carportWidth/roofWidth)+1);
        return amount;
    }


    public static int calcSubStarboardsBackAndFront(int carportWidth, int subStarboardBackAndFrontLength){
        //((carportWidth+5)/subStarboardLength)*2+1; is the best for economical reasons,
        // but the following is beautiful and manageable;
        int amount = 0;
        if(carportWidth<subStarboardBackAndFrontLength){
            amount = 2;
        } else if(carportWidth>subStarboardBackAndFrontLength && carportWidth < (subStarboardBackAndFrontLength*2)){
            amount = 4;
        } else if(carportWidth>(subStarboardBackAndFrontLength*2)){
            amount = 6;
        }

        return amount;
    }

    public static int calcSubStarboardsSides(int carportLength, int subStarboardSidesLength){
        //((carportLength+5)/subStarboardLength)*2+1; is the best for economical reasons,
        // but the following is beautiful and manageable;
        int amount = 0;
        if(carportLength<subStarboardSidesLength){
            amount = 2;
        } else if(carportLength>subStarboardSidesLength){
            amount = 4;
        }

        return amount;
    }
    public static int calcOverSternFor(int carportWidth, int overSternForLength){
        //((carportWidth+5)/overSternForLength)*2+1; is the best for economical reasons,
        // but the following is beautiful and manageable;
        int amount = 0;
        if(carportWidth<overSternForLength){
            amount = 2;
        } else if(carportWidth>overSternForLength && carportWidth < (overSternForLength*2)){
            amount = 4;
        } else if(carportWidth>(overSternForLength*2)){
            amount = 6;
        }

        return amount;
    }
    public static int calcOverSternSider(int carportLength, int overSternSiderLength) {
        //((carportLength+5)/OverSternSiderLength)*2+1; is the best for economical reasons,
        // but the following is beautiful and manageable;
        int amount = 0;
        if (carportLength < overSternSiderLength) {
            amount = 2;
        } else if (carportLength > overSternSiderLength) {
            amount = 4;
        }
        return amount;

    }
    public static int calcVandBrædtSider(int carportLength, int vandBrædtSiderLength) {
        //((carportLength+5)/vandBrædtSiderLength)*2+1; is the best for economical reasons,
        // but the following is beautiful and manageable;
        int amount = 0;
        if (carportLength < vandBrædtSiderLength) {
            amount = 2;
        } else if (carportLength > vandBrædtSiderLength) {
            amount = 4;
        }
        return amount;
    }
    public static int calcVandBrædtFront(int carportWidth, int vandBrædtFrontLength){
        //((carportWidth+5)/overSternForLength)*2+1; is the best for economical reasons,
        // but the following is beautiful and manageable;
        int amount = 0;
        if(carportWidth<vandBrædtFrontLength){
            amount = 1;
        } else if(carportWidth>vandBrædtFrontLength ){
            amount = 2;
        } else if(carportWidth>(vandBrædtFrontLength*2)){
            amount = 3;
        }

        return amount;
    }


}
