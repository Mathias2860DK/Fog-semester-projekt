package business.entities;

public class Carport {
    private int carportWidth;
    private int carportLength;
    private final int carportHeight = 210;
    private String roof;
    private int roofPitch;

    public Carport(int carportWidth, int carportLength, String roof, int roofPitch) {
        this.carportWidth = carportWidth;
        this.carportLength = carportLength;
        this.roof = roof;
        this.roofPitch = roofPitch;
    }

    public int getCarportWidth() {
        return carportWidth;
    }

    public void setCarportWidth(int carportWidth) {
        this.carportWidth = carportWidth;
    }

    public int getCarportLength() {
        return carportLength;
    }

    public void setCarportLength(int carportLength) {
        this.carportLength = carportLength;
    }

    public int getCarportHeight() {
        return carportHeight;
    }

    public String getRoof() {
        return roof;
    }

    public void setRoof(String roof) {
        this.roof = roof;
    }

    public int getRoofPitch() {
        return roofPitch;
    }

    public void setRoofPitch(int roofPitch) {
        this.roofPitch = roofPitch;
    }
}
