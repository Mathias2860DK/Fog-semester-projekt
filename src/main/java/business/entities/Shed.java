package business.entities;

public class Shed {
    private int shedLength;
    private int shedWidth;
    private int postAmount = 4;
    private boolean fullSize;
    private int carportWidth;


    public Shed(int carportWidth) {
this.carportWidth = carportWidth;
        this.shedLength = shedLength;
        this.shedWidth = 190;//Only shed width
        this.fullSize = true;
    }

    public boolean isFullSize() {
        return fullSize;
    }

    public void setFullSize(boolean fullSize) {
        if (fullSize){
            this.shedLength = carportWidth-70;
        } else if(!fullSize) {
            this.shedLength = (carportWidth/2)-35;
        }
        this.fullSize = fullSize;
    }

    public void setShedWidthIfNoShed(){
        this.postAmount = 0;
        this.shedWidth = 0;
    }

    public void setShedLength(int shedLength) {
        this.shedLength = shedLength;
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
