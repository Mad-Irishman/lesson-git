package autoservice.manager.impl;

import autoservice.manager.ServiceManagerInterface;
import autoservice.models.Garage;
import autoservice.models.GaragePlace;
import autoservice.models.Master;
import autoservice.models.order.Order;
import autoservice.models.order.status.OrderStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ServiceManager implements ServiceManagerInterface {
    private final List<Master> masters;
    private final Garage garages;
    private final List<Order> orders;

    public ServiceManager() {
        this.masters = new ArrayList<>();
        this.garages = new Garage();
        this.orders = new ArrayList<>();
    }

    public void addMaster(Master master) {
        this.masters.add(master);
    }

    public void removeMaster(Master master) {
        if (master.isAvailable()) {
            this.masters.remove(master);
        } else {
            System.out.println("It is impossible to delete a master because he has an order");
        }
    }

    public List<Master> getMastersByOrders(Order order) {
        List<Master> orderMasters = new ArrayList<>();
        for (Master master: masters) {
            if (master.getOrdersMaster() != null ) {
                orderMasters.add(master);
            }
        }
        return orderMasters;
    }

    public void addGaragePlace(GaragePlace garagePlace) {
        this.garages.addGaragePlace(garagePlace);
    }

    public void removeGaragePlace(GaragePlace garagePlace) {
        if (!garagePlace.isOccupied()) {
            this.garages.removeGaragePlace(garagePlace);
        } else {
            System.out.println("It is impossible to delete a place because the order is there");
        }
    }

    public List<GaragePlace> getAvailableGaragePlaces() {
        List<GaragePlace> availablePlaces = new ArrayList<>();
        for (Garage garage : garages) {
            List<GaragePlace> garageAvailablePlaces = garage.getAvailableGaragePlaces();
            availablePlaces.addAll(garageAvailablePlaces);
        }
        return availablePlaces;
    }

    public void createOrder(String description, Master master, GaragePlace place, LocalDateTime startTime,
            int durationInHours) {
        if (master.isAvailable() && !place.isOccupied()) {
            Order order = new Order(description, master, place, startTime, durationInHours);
            orders.add(order);
            order.getAssignedMaster().setAvailable(false);
            order.getAssignedMaster().assingOrderMaster(order);
            order.getAssignedGaragePlace().setOccupied(true);
            System.out.println("Order created: " + order);
        } else {
            System.out.println("Master or place is not available for order creation.");
        }
    }

    public List<Order> getOrdersByMaster(Master master) {
        List<Order> masterOrders = new ArrayList<>();
        for (Order order: orders) {
            if (order.getAssignedMaster().equals(master)) {
                masterOrders.add(order);
            }
        }
        return masterOrders;
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
            order.getAssignedMaster().setAvailable(true);
            order.getAssignedMaster().assingOrderMaster(null);
            order.getAssignedGaragePlace().setOccupied(false);
            System.out.println("Order removed: " + order);
        } else {
            System.out.println("Order not found: " + order);
        }
    }

    public void completeOrder(Order order) {
        if (order != null && order.getStatusOrder() == OrderStatus.CREATED) {
            order.setStatusOrder(OrderStatus.COMPELETED);
            order.getAssignedMaster().setAvailable(true);
            order.getAssignedMaster().assingOrderMaster(null);
            order.getAssignedGaragePlace().setOccupied(false);
            System.out.println("Order completed: " + order);
        } else {
            System.out.println("Order is already completed or does not exist.");
        }
    }

    public void cancelOrder(Order order) {
        if (order != null && order.getStatusOrder() == OrderStatus.CREATED && orders.contains(order)) {
            order.setStatusOrder(OrderStatus.CANCELLED);
            order.getAssignedMaster().setAvailable(true);
            order.getAssignedMaster().assingOrderMaster(null);
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
            if (order.getIdOrder() != delayedOrder.getIdOrder()) {
                LocalDateTime newStartTime = order.getStartTime().plusHours(delayInHours);
                LocalDateTime newEstimatedEndTime = order.getEndTime().plusHours(delayInHours);
                order.setStartTime(newStartTime);
                order.setEndTime(newEstimatedEndTime);
                System.out.println("Order " + order.getIdOrder() + " adjusted. New start time: " + newStartTime
                        + ", New end time: " + newEstimatedEndTime);
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
        for (GaragePlace place : garages.getAvailableGaragePlaces()) {
            if (!place.isOccupied()) {
                System.out.println(place);
            }
        }
    }

}