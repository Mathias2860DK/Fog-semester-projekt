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
        if (carport.getShed() != null){
            this.hasShed = true;
        }


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
int x2 = 0; //for line field
        int x = 0;//for text field


        for (int i = 0; i < raftersAmount; i++) {
x2 = (100+(55 * (i+1)));
x = (110+(55*i));
if (i == raftersAmount-1){//Makes sure that the line stops at carport width
    x2 = (100+(55 * (i)));
    x = (110+(55*(i-1)));
    //
}
svg.append("<defs>\n" +
        "    <marker id=\"startarrow\" markerWidth=\"10\" markerHeight=\"7\" \n" +
        "    refX=\"10\" refY=\"3.5\" orient=\"auto\">\n" +
        "      <polygon points=\"10 0, 10 7, 0 3.5\" fill=\"black\" />\n" +
        "    </marker>\n" +
        "    <marker id=\"endarrow\" markerWidth=\"10\" markerHeight=\"7\" \n" +
        "    refX=\"0\" refY=\"3.5\" orient=\"auto\" markerUnits=\"strokeWidth\">\n" +
        "        <polygon points=\"0 0, 10 3.5, 0 7\" fill=\"black\" />\n" +
        "    </marker>\n" +
        "  </defs>\n" +
        "  <line x1=\"" + (100+(55 * i)) + "\" y1=\"70\" x2=\"" + x2 + "\" y2=\"70\" stroke=\"#000\" stroke-width=\"1.5\" \n" +
        "marker-end=\"url(#endarrow)\" marker-start=\"url(#startarrow)\" />" +
       "  <text x=\""+ x + "\" y=\"" +50 +"\" fill=\"black\">" + 55/*spacebetween rafters*/ +" cm</text>\n");
        }
    }

    public void omkreds(){
        addRect(100,100,carportWidth,carportLength-5);
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
                "    <line x1=\"100\"  y1=\""+(100+30+carportWidth)+"\" x2=\""+(carportLength+100)+"\"   y2=\""+(100+30+carportWidth)+"\"\n" +
                "          style=\"stroke: #000000;\n" +
                "\tmarker-start: url(#beginArrow);\n" +
                "\tmarker-end: url(#endArrow);\"/>\n" +
                "    <text x=\""+ 30 + "\" y=\"" +((carportWidth/2) +100) +"\" fill=\"black\">" + carportWidth +" cm</text>\n" +
                "    <text x=\"" + (100 + (carportLength/2)) + "\" y=\""+(100+carportWidth+25)+"\" fill=\"black\" >" + carportLength + " cm</text>";
        svg.append(arrows);

    }
    public void remme(){//remme
        int remmeAmount = 2;
        addRect(100,135,5,carportLength-5);
        addRect(100,carportWidth-35+100,5,carportLength-5);
    }

    public void perforatedTape(){//hulbånd
        svg.append("<line stroke-dasharray=\"6\" x1=\" " + (carportLength-190-30+100)
                + "\" x2=\"155\" y1=\"135\" y2=\"" + (carportWidth-35+100)
                + "\" stroke-width=\"1\" stroke=\"black\"></line>\n" +
                "    <line stroke-dasharray=\"6\" x1=\"155\" x2=\"" +(carportLength-190-30+100)
                + "\" y1=\"135\" y2=\"" + (carportWidth-35+100)
                + "\" stroke-width=\"1\" stroke=\"black\"></line>");


    }
    public void posts(){
        int postsAmount = CalcPart.calcPostAmount(carportLength,hasShed);
        int remainingLength = carportLength-100-30;

        if (hasShed){
            remainingLength = remainingLength-190;
            int remainingPosts = postsAmount-9;
            int spaceBetweenPost = 0;
            if (remainingPosts>0){
                spaceBetweenPost = remainingLength/(remainingPosts);
            } else {
                spaceBetweenPost = remainingLength;
            }

            for (int i = 0; i < postsAmount; i++) {
                if (i == 0){
                    addRect(200,130,9.7,9.7);
                    addRect(200,carportWidth+100-30,9.7,9.7);
                    addRect(carportLength-30+100,130,9.7,9.7);
                    addRect(carportLength-30+100,carportWidth+100-30,9.7,9.7);
                    addRect(carportLength-30+100,(carportWidth/2)+100,9.7,9.7);
                    addRect(carportLength-30-190+100,130,9.7,9.7);
                    addRect(carportLength-30-190+100,carportWidth+100-30,9.7,9.7);
                    addRect(carportLength-30-190+100,(carportWidth/2)+100,9.7,9.7);
                } else if (i == 10){
                    addRect(200+spaceBetweenPost,130,9.7,9.7);
                    addRect(200+spaceBetweenPost,carportWidth+100-30,9.7,9.7);
                }

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