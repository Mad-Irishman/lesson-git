import autoservice.manager.impl.ServiceManager;
import autoservice.models.GaragePlace;
import autoservice.models.Master;
import autoservice.models.order.Order;

import java.time.LocalDateTime;


public class Main {
    public static void main(String[] args) {
        ServiceManager manager = new ServiceManager();

        Master master1 = new Master("John Doe");
        Master master2 = new Master("Jane Smith");

        GaragePlace place1 = new GaragePlace(1);
        GaragePlace place2 = new GaragePlace(2);

        manager.createOrder("Rebuild the motor", master2, place2, LocalDateTime.of(2024, 7, 28, 9, 0),
                LocalDateTime.of(2024, 7, 29, 14, 0),
                LocalDateTime.of(2024, 7, 29, 8, 0),
                450.00);

        manager.createOrder("Change Oil", master1, place1, LocalDateTime.of(2024, 7, 29, 12, 0), LocalDateTime.of(2024, 7, 30, 15, 0),
                LocalDateTime.of(2024, 7, 30, 10, 0), 500.00);

        manager.getSortedCurrentOrders();

    }
}









