package web.commands;

import business.entities.Material;
import business.exceptions.UserException;
import business.services.MaterialsFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        List<Material> materialList = new ArrayList<>();
materialList = materialsFacade.getAllMaterials();
request.setAttribute("materialList",materialList);
        return pageToShow;
    }
}
