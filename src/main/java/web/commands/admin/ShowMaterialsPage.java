package web.commands.admin;

import business.entities.Material;
import business.exceptions.UserException;
import business.services.MaterialsFacade;
import web.commands.CommandProtectedPage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class ShowMaterialsPage extends CommandProtectedPage {
    MaterialsFacade materialsFacade;

    public ShowMaterialsPage(String pageToShow, String role) {
        super(pageToShow, role);
        materialsFacade = new MaterialsFacade(database);

    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();
        List<Material> materialList = new ArrayList<>();
        materialList = materialsFacade.getAllMaterials();
        session.setAttribute("materialList", materialList);
        return pageToShow;
    }
}
