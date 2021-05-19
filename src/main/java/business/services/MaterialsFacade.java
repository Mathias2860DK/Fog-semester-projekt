package business.services;

import business.entities.Material;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.MaterialsMapper;
import business.persistence.OrderMapper;

import java.util.List;

public class MaterialsFacade {
    MaterialsMapper materialsMapper;

    public MaterialsFacade(Database database) {
        materialsMapper = new MaterialsMapper(database);
    }

    public List<Material> getAllMaterials() throws UserException {
        return materialsMapper.getAllMaterials();
    }

    public int deleteMaterial(int materialId) throws UserException {
        return materialsMapper.deleteMaterial(materialId);
    }
}
