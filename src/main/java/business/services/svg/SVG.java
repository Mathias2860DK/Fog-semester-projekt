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
    private int carportEndHeight = 230;
    private int carportStartHeight = 220;

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

    public void arrowsAndTextSideSvg() {
        //right side
        addArrowAndText(100 + carportLength + 50, 10, 100 + carportLength + 50, 230, 100 + carportLength + 50, 230 / 2, 220);
        //left side
        addArrowAndText(50, 0, 50, 230, 50, 230 / 2, 230);
    }

    public void addArrowAndText(int x1, int y1, int x2, int y2, int textX, int textY, int textToDisplay) {
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
                "  <line x1=\"" + x1 + "\" y1=\"" + y1 + "\" x2=\"" + x2 + "\" y2=\"" + y2 + "\" stroke=\"#000\" stroke-width=\"1.5\" \n" +
                "marker-end=\"url(#endarrow)\" marker-start=\"url(#startarrow)\" />" +
                "  <text x=\"" + textX + "\" y=\"" + textY + "\" fill=\"black\">" + textToDisplay + " cm</text>\n ");

    }

    public void addRoof() {//add roof and base
        //base line
        addLine(100, carportEndHeight, carportLength + 100, carportEndHeight);

        //første tag sternbrædt
        //øverste linje:
        addLine(100, 0, carportLength + 100, carportEndHeight - carportStartHeight);
        //luk tag for ende
        addLine(100, 10, 100, 0);
        //luk tag bag ende
        addLine(100 + carportLength, 10 + 10, carportLength + 100, 10);
        //næstøverste linje:
        addLine(100, 10, carportLength + 100, 20);

        //andet tag sternbrædt
        //øverste linje (kollidere med forrige linje)
        addLine(100, 10, carportLength + 100, 20);
        //luk for bagende andet sternbrædt
        addLine(100 + carportLength, 20, carportLength + 100, 30);
        //luk for forende andet sternbrædt
        addLine(100, 20, 100, 10);
        //tredje øverste linje
        addLine(100, 20, carportLength + 100, 30);

    }

    public void addLine(int x1, int y1, int x2, int y2) {
        svg.append("<line x1=\"" + x1 + "\" y1=\"" + y1 + "\" x2=\"" + x2 + "\" y2=\"" + y2 + "\" style=\"stroke:#000000; stroke-width:2\" />");
    }


    public SVG(int x, int y, String viewBox, int width, int height, Carport carport) {
        this.x = x;
        this.y = y;
        this.viewBox = viewBox;
        this.width = width;
        this.height = height;
        svg.append(String.format(headerTemplate, height, width, viewBox, x, y));
        if (carport.getShed() != null) {
            this.hasShed = true;
        }


        this.carportLength = carport.getCarportLength();
        this.carportWidth = carport.getCarportWidth();
        if (carport.getShed() != null) {
            this.shedLength = carport.getShed().getShedLength();
            this.shedWidth = carport.getShed().getShedWidth();
        }
    }


    public String generateSvgTop() {
        omkreds();
        arrowOmkreds();
        remme();
        rafters();
        raftersArrows();
        posts();
        perforatedTape();

        return svg.toString();
    }

    public String generateSvgSide() {
        addRoof();
        arrowsAndTextSideSvg();
        return svg.toString();
    }


    public void raftersArrows() {

    }

    public void rafters() {//spær
        int raftersAmount = CalcPart.calcRafters(carportLength, 55);//Fog standards
        for (int i = 0; i < raftersAmount; i++) {

            addRect(100 + (55 * i), 100, carportWidth, 4.5);
        }
        int x2 = 0; //for line field
        int x = 0;//for text field


        for (int i = 0; i < raftersAmount; i++) {
            x2 = (100 + (55 * (i + 1)));
            x = (110 + (55 * i));
            if (i == raftersAmount - 1) {//Makes sure that the line stops at carport width
                x2 = (100 + (55 * (i)));
                x = (110 + (55 * (i - 1)));
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
                    "  <line x1=\"" + (100 + (55 * i)) + "\" y1=\"70\" x2=\"" + x2 + "\" y2=\"70\" stroke=\"#000\" stroke-width=\"1.5\" \n" +
                    "marker-end=\"url(#endarrow)\" marker-start=\"url(#startarrow)\" />" +
                    "  <text x=\"" + x + "\" y=\"" + 50 + "\" fill=\"black\">" + 55/*spacebetween rafters*/ + " cm</text>\n");
        }
    }

    public void omkreds() {
        addRect(100, 100, carportWidth, carportLength - 5);
    }

    public void arrowOmkreds() {
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
                "    <line x1=\"50\"  y1=\"100\" x2=\"50\"   y2=\"" + (carportWidth + 100) + "\"\n" +
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
                "    <line x1=\"100\"  y1=\"" + (100 + 30 + carportWidth) + "\" x2=\"" + (carportLength + 100) + "\"   y2=\"" + (100 + 30 + carportWidth) + "\"\n" +
                "          style=\"stroke: #000000;\n" +
                "\tmarker-start: url(#beginArrow);\n" +
                "\tmarker-end: url(#endArrow);\"/>\n" +
                "    <text x=\"" + 30 + "\" y=\"" + ((carportWidth / 2) + 100) + "\" fill=\"black\">" + carportWidth + " cm</text>\n" +
                "    <text x=\"" + (100 + (carportLength / 2)) + "\" y=\"" + (100 + carportWidth + 25) + "\" fill=\"black\" >" + carportLength + " cm</text>";
        svg.append(arrows);

    }

    public void remme() {//remme
        int remmeAmount = 2;
        addRect(100, 135, 5, carportLength - 5);
        addRect(100, carportWidth - 35 + 100, 5, carportLength - 5);
    }

    public void perforatedTape() {//hulbånd
        if(hasShed){
            svg.append("<line stroke-dasharray=\"6\" x1=\" " + (carportLength - 190 - 30 + 100)
                    + "\" x2=\"155\" y1=\"135\" y2=\"" + (carportWidth - 35 + 100)
                    + "\" stroke-width=\"1\" stroke=\"black\"></line>\n" +
                    "    <line stroke-dasharray=\"6\" x1=\"155\" x2=\"" + (carportLength - 190 - 30 + 100)
                    + "\" y1=\"135\" y2=\"" + (carportWidth - 35 + 100)
                    + "\" stroke-width=\"1\" stroke=\"black\"></line>");
        } else {
            svg.append("<line stroke-dasharray=\"6\" x1=\" " + (carportLength - 55 + 100)
                    + "\" x2=\"155\" y1=\"135\" y2=\"" + (carportWidth - 35 + 100)
                    + "\" stroke-width=\"1\" stroke=\"black\"></line>\n" +
                    "    <line stroke-dasharray=\"6\" x1=\"155\" x2=\"" + (carportLength - 55 + 100)
                    + "\" y1=\"135\" y2=\"" + (carportWidth - 35 + 100)
                    + "\" stroke-width=\"1\" stroke=\"black\"></line>");

        }



    }

    public void posts() {
        int postsAmount = CalcPart.calcPostAmount(carportLength, hasShed);
        int remainingLength = carportLength - 100 - 30;

        if (hasShed) {
            remainingLength = remainingLength - 190;
            int remainingPosts = postsAmount - 9;
            int spaceBetweenPosts = 0;
            if (remainingPosts > 0) {
                spaceBetweenPosts = remainingLength / (remainingPosts);
            } else {
                spaceBetweenPosts = remainingLength;
            }
            addRect(200, 130, 9.7, 9.7);
            addRect(200, carportWidth + 100 - 30, 9.7, 9.7);
            addRect(carportLength - 30 + 100, 130, 9.7, 9.7);
            addRect(carportLength - 30 + 100, carportWidth + 100 - 30, 9.7, 9.7);
            addRect(carportLength - 30 + 100, (carportWidth / 2) + 100, 9.7, 9.7);
            addRect(carportLength - 30 - 190 + 100, 130, 9.7, 9.7);
            addRect(carportLength - 30 - 190 + 100, carportWidth + 100 - 30, 9.7, 9.7);
            addRect(carportLength - 30 - 190 + 100, (carportWidth / 2) + 100, 9.7, 9.7);
            if (postsAmount > 10) {
                addRect(200 + spaceBetweenPosts, 130, 9.7, 9.7);
                addRect(200 + spaceBetweenPosts, carportWidth + 100 - 30, 9.7, 9.7);
            }

        } else {
            int remainingPosts = postsAmount - 4;
            int spaceBetweenPosts = 0;
            if (remainingPosts > 0) {
                spaceBetweenPosts = remainingLength / (remainingPosts);
            } else {
                spaceBetweenPosts = remainingLength;
            }
            addRect(200, 130, 9.7, 9.7);
            addRect(200, carportWidth + 100 - 30, 9.7, 9.7);
            addRect(carportLength - 30 + 100, 130, 9.7, 9.7);
            addRect(carportLength - 30 + 100, carportWidth + 100 - 30, 9.7, 9.7);
            if (postsAmount > 4) {
                addRect(200 + spaceBetweenPosts, 130, 9.7, 9.7);
                addRect(200 + spaceBetweenPosts, carportWidth + 100 - 30, 9.7, 9.7);
            } else if (postsAmount > 6) {
                addRect(200 + (spaceBetweenPosts * 2), 130, 9.7, 9.7);
                addRect(200 + (spaceBetweenPosts * 2), carportWidth + 100 - 30, 9.7, 9.7);
            }
        }

    }


    public void addRect(int x, int y, double height, double width) {
        svg.append(String.format(rectTemplate, x, y, height, width));
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