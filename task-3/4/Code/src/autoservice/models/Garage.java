package autoservice.models;

import java.util.List;
import java.util.ArrayList;

public class Garage {
    private List<GaragePlace> garagePlaces;

    public Garage() {
        this.garagePlaces = new ArrayList<>();
    }

    public void addGaragePlace(GaragePlace place) {
        garagePlaces.add(place);
    }

    public void removeGaragePlace(GaragePlace place) {
        garagePlaces.remove(place);
    }

    public List<GaragePlace> getGaragePlaces() {
        return garagePlaces;
    }

    public List<GaragePlace> getAvailableGaragePlaces() {
        List<GaragePlace> availablePlaces = new ArrayList<>();
        for (GaragePlace place : garagePlaces) {
            if (!place.isOccupied()) {
                availablePlaces.add(place);
            }
        }
        return availablePlaces;
    }

    @Override
    public String toString() {
        return String.format("Garage{garagePlaces=%s}", garagePlaces);
    }
}
