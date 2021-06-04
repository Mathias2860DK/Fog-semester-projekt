package business.services.svg;

import business.calculations.CalcPart;
import business.entities.Carport;

public class SvgSide extends SVG {

    StringBuilder svg = new StringBuilder();

    private int carportWidth;
    private int carportLength;


    private boolean hasShed;
    private int shedLength;
    private int shedWidth;
    private boolean fullSize;

    public SvgSide(int x, int y, String viewBox, int width, int height, Carport carport) {
        //Starterkode til SVG
        svg.append(String.format(headerTemplate, height, width, viewBox, x, y));
        this.hasShed = carport.getShed().isHasShed();
        if (hasShed) {
            this.hasShed = true;
        }
        if (carport.getShed().isFullSize()) {
            this.fullSize = true;
        }


        this.carportLength = carport.getCarportLength();
        this.carportWidth = carport.getCarportWidth();
        this.shedLength = carport.getShed().getShedLength();
        this.shedWidth = carport.getShed().getShedWidth();
    }

    public String generateSvgSide() {
        addRoof();
        arrowsAndTextSideSvg();
        addPostsSide();
        return svg + "</svg>";
    }
    public void addPostsSide(){
        int postsAmount = CalcPart.calcPostAmount(carportLength, hasShed);
        int remainingLength = carportLength - 100 - 30;
        if (hasShed){
            remainingLength = remainingLength - 190;
            int remainingPosts = (postsAmount-3)/2;
            int spaceBetweenPosts = 0;
            if (remainingPosts > 0) {
                spaceBetweenPosts = remainingLength / (remainingPosts)*2;
            } else {
                spaceBetweenPosts = remainingLength;
            }
            addShedSide();
            addRect(200, 0, carportEndHeight, 9.7,svg);
            addRect(carportLength - 30 + 100, 10, carportStartHeight, 9.7,svg);
            addRect(carportLength - 30 - 190 + 100, 10, carportEndHeight-5, 9.7,svg);
            addArrowAndText(100,carportStartHeight+50,200,carportStartHeight+50,120,carportStartHeight+70, 100,svg);
            addArrowAndText(carportLength-190-30+100,carportStartHeight+50,carportLength-30+100,carportStartHeight+50,carportLength-30+100-95-30,carportStartHeight+70,190,svg);
            addArrowAndText(carportLength-30+100,carportStartHeight+50,carportLength+100,carportStartHeight+50,carportLength-20+100,carportStartHeight+70,30,svg);

            if (postsAmount > 10) {
                addRect(200 + spaceBetweenPosts, 5, carportEndHeight-5, 9.7,svg);
                addArrowAndText(200,carportStartHeight+50,200+spaceBetweenPosts,carportStartHeight+50,200+(spaceBetweenPosts/2)-30,carportStartHeight+70,spaceBetweenPosts,svg);
                addArrowAndText(200+spaceBetweenPosts,carportStartHeight+50,carportLength-190-30+100,carportStartHeight+50,(carportLength-190-30+100)-(spaceBetweenPosts/2),carportStartHeight+70,spaceBetweenPosts,svg);
            } else {
                addArrowAndText(200,carportStartHeight+50,carportLength-190-30+100,carportStartHeight+50,(carportLength-190-30+100)-(remainingLength/2),carportStartHeight+70,remainingLength,svg);
            }

        } else {
            int remainingPosts = ((postsAmount - 4)/2)+1;//for at finde den mellemrum der skal være på den ene side dividere vi med 2, og plusser med en da vi skal finde afstand
            int spaceBetweenPosts = 0;
            if (remainingPosts > 0) {
                spaceBetweenPosts = remainingLength / remainingPosts;
            } else {
                spaceBetweenPosts = remainingLength;
            }
            addRect(200, 0, carportEndHeight, 9.7,svg);//første stolpe
            addRect(carportLength - 30 + 100, 10, carportStartHeight, 9.7,svg);//sidste stolpe
            addArrowAndText(100,carportStartHeight+50,200,carportStartHeight+50,120,carportStartHeight+70, 100,svg);
            addArrowAndText(carportLength-30+100,carportStartHeight+50,carportLength+100,carportStartHeight+50,carportLength-20+100,carportStartHeight+70,30,svg);

            if (postsAmount > 4) {
                addRect(200 + spaceBetweenPosts, 5, carportEndHeight-5, 9.7,svg);//
                addArrowAndText(200,carportStartHeight+50,200+spaceBetweenPosts,carportStartHeight+50,200+(spaceBetweenPosts/2),carportStartHeight+70,spaceBetweenPosts,svg);
                addArrowAndText(200+spaceBetweenPosts,carportStartHeight+50,carportLength-30+100,carportStartHeight+50,(carportLength-30+100)-(spaceBetweenPosts/2),carportStartHeight+70,spaceBetweenPosts,svg);
            } else {
                addArrowAndText(200,carportStartHeight+50,carportLength-30+100,carportStartHeight+50,(carportLength-30+100)-(remainingLength/2),carportStartHeight+70,remainingLength,svg);
            } if (postsAmount > 6) {
                addRect(200 + (spaceBetweenPosts*2), 10, carportEndHeight-5, 9.7,svg);
                addArrowAndText(200+spaceBetweenPosts,carportStartHeight+50,200+(spaceBetweenPosts*2),carportStartHeight+50,200+spaceBetweenPosts+(spaceBetweenPosts/2),carportStartHeight+70,spaceBetweenPosts,svg);

            }

        }
    }
    public void addShedSide(){
        for (int i = 0; i < 38; i++) {
            addRect((carportLength - 30 - 190 + 100)+(i*5),10,carportStartHeight,5,svg);

        }
    }

    public void arrowsAndTextSideSvg() {
        //right side
        addArrowAndText(100 + carportLength + 50, 10, 100 + carportLength +
                50, 230, 100 + carportLength + 50, 230 / 2, 220,svg);
        //left side
        addArrowAndText(50, 0, 50, 230, 50, 230 / 2, 230,svg);
    }


    public void addRoof() {//add roof and base
        //base line
        addLine(100, carportEndHeight, carportLength + 100, carportEndHeight,svg);

        //første tag sternbrædt
        //øverste linje:
        addLine(100, 0, carportLength + 100, carportEndHeight - carportStartHeight,svg);
        //luk tag for ende
        addLine(100, 10, 100, 0,svg);
        //luk tag bag ende
        addLine(100 + carportLength, 10 + 10, carportLength + 100, 10,svg);
        //næstøverste linje:
        addLine(100, 10, carportLength + 100, 20,svg);

        //andet tag sternbrædt
        //øverste linje (kollidere med forrige linje)
        addLine(100, 10, carportLength + 100, 20,svg);
        //luk for bagende andet sternbrædt
        addLine(100 + carportLength, 20, carportLength + 100, 30,svg);
        //luk for forende andet sternbrædt
        addLine(100, 20, 100, 10,svg);
        //tredje øverste linje
        addLine(100, 20, carportLength + 100, 30,svg);
    }
}
