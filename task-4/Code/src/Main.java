import autoservice.manager.impl.ServiceManager;
import autoservice.models.Garage;
import autoservice.models.GaragePlace;
import autoservice.models.Master;


import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        ServiceManager manager = new ServiceManager();

        Master master1 = new Master("John Doe");
        GaragePlace place1 = new GaragePlace(1);
        GaragePlace place2 = new GaragePlace(2);
        GaragePlace place3 = new GaragePlace(3);
        manager.addGaragePlace(place1);
        manager.addGaragePlace(place2);
        manager.addGaragePlace(place3);



        manager.createOrder("Change Oil", master1, place1, LocalDateTime.now(), 2);
        manager.getAvailableGaragePlaces();

    }
}








