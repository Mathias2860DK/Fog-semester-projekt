package business.entities;

public class Material {
    private String description; //Describes how to use the material
    private int length; // length dimension
    private int width; //width dimension
    private int height; // the height of the material
    private String unit;
    private double price; // price of the material
    private String materialType;//length and width dimension
    private int materialId;

    public Material(String description, int length, int width, int height, String unit, double price, String materialType, int materialId) {
        this.description = description;
        this.length = length;
        this.width = width;
        this.height = height;
        this.unit = unit;
        this.price = price;
        this.materialType = materialType;
        this.materialId = materialId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }
}
