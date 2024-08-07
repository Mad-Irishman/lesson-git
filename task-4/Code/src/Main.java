import autoservice.manager.impl.ServiceManager;
import autoservice.models.Garage;
import autoservice.models.GaragePlace;
import autoservice.models.Master;
import autoservice.models.order.Order;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ServiceManager manager = new ServiceManager();

        Master master1 = new Master("John Doe");
        Master master2 = new Master("Jane Smith");
        Master master3 = new Master("Alice Johnson");

        GaragePlace place1 = new GaragePlace(1);
        GaragePlace place2 = new GaragePlace(2);
        Garage garage = new Garage();
        garage.addGaragePlace(place1);
        garage.addGaragePlace(place2);


        manager.addMaster(master1);
        manager.addMaster(master2);
        manager.addMaster(master3);

        LocalDateTime startTime1 = LocalDateTime.now().plusHours(1);
        LocalDateTime startTime2 = LocalDateTime.now().plusHours(2);

        manager.createOrder("Change oil", master1, place1, startTime1, 2);
        manager.createOrder("Fix brakes", master2, place2, startTime2, 3);

        System.out.println("Masters sorted by availability and name:");
        List<Master> mastersSortedByAvailabilityAndName = manager.getMastersSortedByAvailabilityAndName();
        for (Master master : mastersSortedByAvailabilityAndName) {
            System.out.println(master.getName());
        }
    }
}









