package autoservice.manager.impl;

import autoservice.manager.ServiceManagerInterface;
import autoservice.models.Garage;
import autoservice.models.GaragePlace;
import autoservice.models.Master;
import autoservice.models.Order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ServiceManager implements ServiceManagerInterface {
    private List<Master> masters;
    private Garage garage;
    private List<Order> orders;

    public ServiceManager() {
        this.masters = new ArrayList<>();
        this.garage = new Garage();
        this.orders = new ArrayList<>();
    }

    public void addMaster(Master master) {
        masters.add(master);
    }

    public void removeMaster(Master master) {
        if (masters.contains(master)) {
            masters.remove(master);
            System.out.println("Master removed: " + master);
        } else {
            System.out.println("Master not found: " + master);
        }
    }

    public void addGaragePlace(GaragePlace garagePlace) {
        garage.addGaragePlace(garagePlace);
    }

    public void removeGaragePlace(GaragePlace garagePlace) {
        garage.removeGaragePlace(garagePlace);
        System.out.println("Garage place removed: " + garagePlace);
    }

    public void createOrder(String description, Master master, GaragePlace place, LocalDateTime startTime, int durationInHours) {
        if (master.isAvailable() && !place.isOccupied()) {
            Order order = new Order(description, master, place, startTime, durationInHours);
            orders.add(order);
            master.setAvailable(false);
            place.setOccupied(true);
            System.out.println("Order created: " + order);
        } else {
            System.out.println("Master or place is not available for order creation.");
        }
    }

    public Order getOrderById(int id) {
        for (Order order : orders) {
            if (order.getIdOrder() == id) {
                return order;
            }
        }
        System.out.println("Order not found: " + id);
        return null;
    }

    public void removeOrder(Order order) {
        if (orders.remove(order)) {
            System.out.println("Order removed: " + order);
        } else {
            System.out.println("Order not found: " + order);
        }
    }

    public void completeOrder(Order order) {
        if (order != null && order.getStatusOrder() == Order.OrderStatus.CREATED) {
            order.setStatusOrder(Order.OrderStatus.COMPLETED);
            order.getAssignedMaster().setAvailable(true);
            order.getAssignedGaragePlace().setOccupied(false);
            System.out.println("Order completed: " + order);
        } else {
            System.out.println("Order is already completed or does not exist.");
        }
    }

    public void cancelOrder(Order order) {
        if (order != null && orders.contains(order) && order.getStatusOrder() == Order.OrderStatus.CREATED) {
            order.setStatusOrder(Order.OrderStatus.CANCELLED);
            order.getAssignedMaster().setAvailable(true);
            order.getAssignedGaragePlace().setOccupied(false);
            System.out.println("Order cancelled: " + order);
        } else {
            System.out.println("Order not found: " + order);
        }
    }

    public void adjustOrdersForDelay(int orderId, int delayInHours) {
        Order delayedOrder = getOrderById(orderId);
        if (delayedOrder == null) {
            System.out.println("Order with ID " + orderId + " not found.");
            return;
        }

        LocalDateTime newEndTime = delayedOrder.getEndTime().plusHours(delayInHours);
        delayedOrder.setEndTime(newEndTime);
        System.out.println("Order " + delayedOrder.getIdOrder() + " delayed. New end time: " + newEndTime);

        for (Order order : orders) {
            if (order.getStartTime().isAfter(delayedOrder.getEndTime())) {
                LocalDateTime newStartTime = order.getStartTime().plusHours(delayInHours);
                LocalDateTime newEstimatedEndTime = order.getEndTime().plusHours(delayInHours);
                order.setStartTime(newStartTime);
                order.setEndTime(newEstimatedEndTime);
                System.out.println("Order " + order.getIdOrder() + " adjusted. New start time: " + newStartTime + ", New end time: " + newEstimatedEndTime);
            }
        }
    }

    public void showAllOrders() {
        System.out.println("All Orders:");
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    public void showAvailableMasters() {
        System.out.println("Available Masters:");
        for (Master master : masters) {
            if (master.isAvailable()) {
                System.out.println(master);
            }
        }
    }

    public void showAvailableGaragePlaces() {
        System.out.println("Available Garage Places:");
        for (GaragePlace place : garage.getAvailableGaragePlaces()) {
            if (!place.isOccupied()) {
                System.out.println(place);
            }
        }
    }
}