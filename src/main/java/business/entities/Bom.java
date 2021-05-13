package business.entities;

import java.util.List;

public class Bom {
    private List<Material> materialList;
    private double price;

    public Bom(List<Material> materialList, double price) {
        this.materialList = materialList;
        this.price = price;
    }

    public List<Material> getMaterialList() {
        return materialList;
    }

    public void setMaterialList(List<Material> materialList) {
        this.materialList = materialList;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
