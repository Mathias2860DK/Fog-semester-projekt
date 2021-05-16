package business.entities;

public class Shed {
    private int shedLength;
    private int shedWidth;
    private int postAmount = 4;

    public Shed(int shedLength, int shedWidth) {
        this.shedLength = shedLength;
        this.shedWidth = shedWidth;
    }

    public int getShedLength() {
        return shedLength;
    }

    public int getShedWidth() {
        return shedWidth;
    }

    @Override
    public String toString() {
        return "Shed{" +
                "shedLength=" + shedLength +
                ", shedWidth=" + shedWidth +
                ", postAmount=" + postAmount +
                '}';
    }

    public int getPostAmount() {
        return postAmount;
    }
}
