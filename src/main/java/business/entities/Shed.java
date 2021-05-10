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

    public int getPostAmount() {
        return postAmount;
    }
}
