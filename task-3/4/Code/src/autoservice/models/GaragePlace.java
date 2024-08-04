package autoservice.models;

public class GaragePlace {
    private int placeNumber;
    private boolean isOccupied = false;

    public GaragePlace(int placeNumber) {
        this.placeNumber = placeNumber;
    }

    public int getPlaceNumber() {
        return this.placeNumber;
    }

    public void setPlaceNumber(int placeNumber) {
        this.placeNumber = placeNumber;
    }

    public boolean isOccupied() {
        return this.isOccupied;
    }

    public void setOccupied(boolean occupied) {
        this.isOccupied = occupied;
    }

    @Override
    public String toString() {
        return String.format("GaragePlace{placeNumber=%d, isOccupied=%b}", placeNumber, isOccupied);
    }
}