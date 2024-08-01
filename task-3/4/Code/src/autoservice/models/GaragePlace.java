package autoservice.models;

public class GaragePlace {
    private int placeNumber;
    private boolean isOccupied;

    public GaragePlace(int placeNumber) {
        this.placeNumber = placeNumber;
        this.isOccupied = false;
    }

    public int getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(int placeNumber) {
        this.placeNumber = placeNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    @Override
    public String toString() {
        return String.format("GaragePlace{placeNumber=%d, isOccupied=%b}", placeNumber, isOccupied);
    }
}