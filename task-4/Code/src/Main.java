import autoservice.manager.impl.ServiceManager;
import autoservice.models.GaragePlace;
import autoservice.models.Master;


import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        ServiceManager manager = new ServiceManager();

        Master master1 = new Master("John Doe");
        GaragePlace place1 = new GaragePlace(1);

        manager.createOrder("Change Oil", master1, place1, LocalDateTime.now(), 2);



        manager.showAllOrders();
        manager.showAvailableMasters();
        manager.showAvailableGaragePlaces();

    }
}








