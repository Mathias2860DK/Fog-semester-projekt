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

    //Alle mål er forskudt med 100px, da vi ikke laver SVG tegning inde i svg tegning.

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
        omkreds();
        arrowOmkreds();
        remme();
        rafters();
        raftersArrows();
        posts();
        perforatedTape();

        return svg.toString();
    }


    public void raftersArrows(){

    }
    public void rafters() {//spær
        int raftersAmount = CalcPart.calcRafters(carportLength, 55);//Fog standards
        for (int i = 0; i < raftersAmount; i++) {

            addRect(100+(55 * i), 100, carportWidth, 4.5);
        }

        for (int i = 0; i < raftersAmount; i++) {

svg.append("<defs>\n" +
        "    <marker id=\"startarrow\" markerWidth=\"10\" markerHeight=\"7\" \n" +
        "    refX=\"10\" refY=\"3.5\" orient=\"auto\">\n" +
        "      <polygon points=\"10 0, 10 7, 0 3.5\" fill=\"red\" />\n" +
        "    </marker>\n" +
        "    <marker id=\"endarrow\" markerWidth=\"10\" markerHeight=\"7\" \n" +
        "    refX=\"0\" refY=\"3.5\" orient=\"auto\" markerUnits=\"strokeWidth\">\n" +
        "        <polygon points=\"0 0, 10 3.5, 0 7\" fill=\"red\" />\n" +
        "    </marker>\n" +
        "  </defs>\n" +
        "  <line x1=\"" + (100+(55 * i)) + "\" y1=\"50\" x2=\"" + (100+(55 * i)+1) + "\" y2=\"50\" stroke=\"#000\" stroke-width=\"1\" \n" +
        "  marker-end=\"url(#endarrow)\" marker-start=\"url(#startarrow)\" />");
        }
    }

    public void omkreds(){
        addRect(100,100,600,775);
    }
    public void arrowOmkreds(){
        String arrows = "<defs>\n" +
                "        <marker\n" +
                "                id=\"beginArrow\"\n" +
                "                markerWidth=\"12\"\n" +
                "                markerHeight=\"12\"\n" +
                "                refX=\"0\"\n" +
                "                refY=\"6\"\n" +
                "                orient=\"auto\">\n" +
                "            <path d=\"M0,6 L12,0 L12,12 L0,6\" style=\"fill: #000000;\" />\n" +
                "        </marker>\n" +
                "        <marker\n" +
                "                id=\"endArrow\"\n" +
                "                markerWidth=\"12\"\n" +
                "                markerHeight=\"12\"\n" +
                "                refX=\"12\"\n" +
                "                refY=\"6\"\n" +
                "                orient=\"auto\">\n" +
                "            <path d=\"M0,0 L12,6 L0,12 L0,0 \" style=\"fill: #000000;\" />\n" +
                "        </marker>\n" +
                "    </defs>\n" +
                "    <line x1=\"50\"  y1=\"100\" x2=\"50\"   y2=\"" + (carportWidth+100) + "\"\n" +
                "          style=\"stroke: #000000;\n" +
                "\tmarker-start: url(#beginArrow);\n" +
                "\tmarker-end: url(#endArrow);\"/>\n" +
                "    <defs>\n" +
                "        <marker\n" +
                "                id=\"beginArrow\"\n" +
                "                markerWidth=\"12\"\n" +
                "                markerHeight=\"12\"\n" +
                "                refX=\"0\"\n" +
                "                refY=\"6\"\n" +
                "                orient=\"auto\">\n" +
                "            <path d=\"M0,6 L12,0 L12,12 L0,6\" style=\"fill: #000000;\" />\n" +
                "        </marker>\n" +
                "        <marker\n" +
                "                id=\"endArrow\"\n" +
                "                markerWidth=\"12\"\n" +
                "                markerHeight=\"12\"\n" +
                "                refX=\"12\"\n" +
                "                refY=\"6\"\n" +
                "                orient=\"auto\">\n" +
                "            <path d=\"M0,0 L12,6 L0,12 L0,0 \" style=\"fill: #000000;\" />\n" +
                "        </marker>\n" +
                "    </defs>\n" +
                "    <line x1=\"100\"  y1=\"750\" x2=\"880\"   y2=\"750\"\n" +
                "          style=\"stroke: #000000;\n" +
                "\tmarker-start: url(#beginArrow);\n" +
                "\tmarker-end: url(#endArrow);\"/>\n" +
                "    <text x=\""+ 30 + "\" y=\"" +((carportWidth/2) +100) +"\" fill=\"black\">" + carportWidth +" cm</text>\n" +
                "    <text x=\"" + ((carportLength/2) + 85) + "\" y=\"750\" fill=\"black\" >" + carportLength + " cm</text>";
        svg.append(arrows);

    }
    public void remme(){//remme
        int remmeAmount = 2;
        addRect(100,135,5,carportLength-5);
        addRect(100,carportWidth-35+100,5,carportLength-5);
    }

    public void perforatedTape(){//hulbånd
        svg.append("<line stroke-dasharray=\"6\" x1=\" " + (carportLength-195-30+100)
                + "\" x2=\"155\" y1=\"135\" y2=\"" + (carportWidth-35+100)
                + "\" stroke-width=\"1\" stroke=\"black\"></line>\n" +
                "    <line stroke-dasharray=\"6\" x1=\"155\" x2=\"" +(carportLength-195-30+100)
                + "\" y1=\"135\" y2=\"" + (carportWidth-35+100)
                + "\" stroke-width=\"1\" stroke=\"black\"></line>");


    }
    public void posts(){
        int postsAmount = CalcPart.calcPostAmount(carportLength);
        int spaceBetweenPosts = (carportLength-100-30)/((postsAmount/2)-1);
        for (int i = 0; i < postsAmount/2; i++) {
            if (i == 0){
                addRect(100, 35, 9.7, 9.7);
                addRect(100, carportWidth-39, 9.7, 9.7);
            } else if (i == (postsAmount/2)-1){
                addRect(carportLength-30, 35, 9.7, 9.7);
                addRect(carportLength-30, carportWidth-39, 9.7, 9.7);
            }else {
                addRect((spaceBetweenPosts*i)+100, 35, 9.7, 9.7);
                addRect((spaceBetweenPosts*i)+100, carportWidth-39, 9.7, 9.7);
            }

        }

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