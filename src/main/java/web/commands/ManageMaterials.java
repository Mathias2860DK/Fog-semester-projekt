package web.commands;

import business.entities.Material;
import business.entities.User;
import business.exceptions.UserException;
import business.services.MaterialsFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ManageMaterials extends CommandProtectedPage {
private MaterialsFacade materialsFacade;
    public ManageMaterials(String pageToShow, String role) {
        super(pageToShow, role);
        materialsFacade = new MaterialsFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();
        int materialId = 0;
        List<Material> materialList = (List<Material>) session.getAttribute("materialList");
        String edit = request.getParameter("materialIdEdit");
        String delete = request.getParameter("materialIdDelete");
        if (edit != null){
            try {
                materialId = Integer.parseInt(edit);
            } catch (NumberFormatException e){
                throw new NumberFormatException(e.getMessage());
            }
            for (Material material: materialList) {
                if (material.getMaterialId() == materialId){
                    session.setAttribute("material",material);
                    return "editMaterialsPage"; //TBD
                }
            }
        }

        if (delete != null){
            try {
                materialId = Integer.parseInt(delete);
            } catch (NumberFormatException e){
                throw new NumberFormatException(e.getMessage());
            }
            //Tests if the material is removed from database and notifies user
int rowsAffcted = materialsFacade.deleteMaterial(materialId);
            if (rowsAffcted > 0){
                //updates the site
                session.setAttribute("materialList",materialsFacade.getAllMaterials());

                request.setAttribute("sucess","Matrialet er nu slettet");
                return "materialspage";
            } else if (rowsAffcted == 0){
                request.setAttribute("error","Der er sket en fejl");
                return "materialspage";
            }
        }
        return pageToShow;
    }
}
