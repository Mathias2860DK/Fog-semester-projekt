package web.commands;

import business.entities.Carport;
import business.exceptions.UserException;
import business.services.svg.SVG;
import business.services.svg.SvgTop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowSVGCommand extends CommandUnprotectedPage {
    public ShowSVGCommand(String pageToShow) {
        super(pageToShow);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
       /*  SVG svg = new SVG(0, 0, "0 0 800 600", 100, 50);
        SvgTop svgTop = new SvgTop(new Carport(600,780,""),svg);
        String svgTopCode = svgTop.createSvgTop();
        request.setAttribute("svgdrawing", svgTopCode.replace(",", "."));//Makes sure that it puts dot instead of comma.
        return pageToShow;*/
        return "";
    }
}
