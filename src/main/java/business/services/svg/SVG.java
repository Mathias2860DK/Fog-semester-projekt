package business.services.svg;

import business.calculations.CalcPart;
import business.entities.Carport;

public class SVG {
    StringBuilder svg = new StringBuilder();
    private int x;
    private int y;
    private String viewBox;
    private int width;
    private int height;

    private int carportWidth;
    private int carportLength;

    private boolean hasShed;
    private int shedLength;
    private int shedWidth;

    private final String headerTemplate = "<svg " +
            "height=\"%d%%\" " +
            "width=\"%d%%\" " +
            "viewBox=\"%s\" " +
            "x=\"%d\"   " +
            "y=\"%d\"   " +
            " preserveAspectRatio=\"xMinYMin\">";
    private final String rectTemplate = "<rect x=\"%d\" y=\"%d\" height=\"%f\" width=\"%f\" style=\"stroke:#000000; fill: #ffffff\" />";

    public SVG(int x, int y, String viewBox, int width, int height, Carport carport) {
        this.x = x;
        this.y = y;
        this.viewBox = viewBox;
        this.width = width;
        this.height = height;
        svg.append(String.format(headerTemplate, height, width, viewBox, x, y));


        this.carportLength = carport.getCarportLength();
        this.carportWidth = carport.getCarportWidth();
        if (carport.getShed() != null){
            this.shedLength = carport.getShed().getShedLength();
            this.shedWidth = carport.getShed().getShedWidth();
        }
    }

    public String generateSvgTop(){
        remme();
        rafters();
        posts();
        perforatedTape();

        return svg.toString();
    }

    public void rafters() {//spær
        int raftersAmount = CalcPart.calcRafters(carportLength, 55);//Fog standards
        for (int i = 0; i < raftersAmount; i++) {

            addRect(55 * i, 0, carportWidth, 4.5);
        }
    }

    public void remme(){//remme
        int remmeAmount = 2;
        addRect(0,35,5,carportLength-5);
        addRect(0,carportWidth-35,5,carportLength-5);
    }

    public void perforatedTape(){//hulbånd
        svg.append("<line stroke-dasharray=\"6\" x1=\" " + (carportLength-195-30)
                + "\" x2=\"55\" y1=\"35\" y2=\"" + (carportWidth-35)
                + "\" stroke-width=\"1\" stroke=\"black\"></line>\n" +
                "    <line stroke-dasharray=\"6\" x1=\"55\" x2=\"" +(carportLength-195-30)
                + "\" y1=\"35\" y2=\"" + (carportWidth-35)
                + "\" stroke-width=\"1\" stroke=\"black\"></line>");


    }
    public void posts(){
        int postsAmount = CalcPart.calcPostAmount(carportLength);

    }

    public void addRect(int x, int y, double height, double width) {
        svg.append(String.format(rectTemplate, x, y, height, width));
    }

    public void addLine(int x1, int y1, int x2, int y2) {
    }

    public void addSvg(SVG innerSVG)//SVG tegning ind i en anden SVG tegning
    {
        svg.append(innerSVG.toString());
    }

    public void addArrows(SVG arrows) {
        svg.append(arrows.toString());
    }


    @Override
    public String toString() {
        return svg.toString() + "</svg>";
    }
}