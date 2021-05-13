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

    public static int calcRafters(int carportLength){//rafters = spær
        //(Carport længde-10) / 55 +1 =  15
return (carportLength-10)/55+1;
    }
    public static int calcRem(int carportLength){//rem engelsk?
        return 2;
    }
}
