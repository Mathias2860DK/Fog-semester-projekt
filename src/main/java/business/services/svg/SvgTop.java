package business.services.svg;

import business.entities.Carport;

public class SvgTop {
    private int carportWidth;
    private int carportLength;

    private boolean hasShed;
    private int shedLength;
    private int shedWidth;
    private String svgString; //Used to convert String builder to String
    //private SVG svg;
    StringBuilder sb;
    private String svgCode;

    private String starterCode;

    private final String rectTemplate = "<rect x=\"%d\" y=\"%d\" height=\"%f\" width=\"%f\" style=\"stroke:#000000; fill: #ffffff\" />";

    public SvgTop(Carport carport, SVG svgObject){
        this.carportLength = carport.getCarportLength();
        this.carportWidth = carport.getCarportWidth();
        if (carport.getShed().getShedLength() != 0){
            this.shedLength = carport.getShed().getShedLength();
            this.shedWidth = carport.getShed().getShedWidth();
        }
        this.sb = new StringBuilder();
    }

    public String createSvgTop(){
        sb.append(starterCode);
        raftersAmount();


        svgCode = sb.toString() + "</svg>";
        return svgCode;
    }


public String raftersAmount(){


    return "";
}


    public String addRect(int x, int y, double height, double width) {
        return String.format(rectTemplate, x, y, height, width);
    }

}
