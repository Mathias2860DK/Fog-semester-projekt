package business.entities;

public class Carport {
    private int carportWidth;
    private int carportLength;
    private final int carportHeightStart = 230;
    private final int carportHeightEnd = 220;
    private String roof;
    private Shed shed;

    public Carport(int carportWidth, int carportLength, String roof, Shed shed) {
        this.carportWidth = carportWidth;
        this.carportLength = carportLength;
        this.roof = roof;
        this.shed = shed;
    }

    public int getCarportHeightStart() {
        return carportHeightStart;
    }

    public int getCarportHeightEnd() {
        return carportHeightEnd;
    }

    public Carport(int carportWidth, int carportLength, String roof) {
        this.carportWidth = carportWidth;
        this.carportLength = carportLength;
        this.roof = roof;
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

    public String getRoof() {
        return roof;
    }

    public void setRoof(String roof) {
        this.roof = roof;
    }
}
