package autoservice.models;

import java.time.LocalDateTime;


public class Order {
    private static int idOrder = 0;
    private OrderStatus statusOrder;
    private String description;
    private Master assignedMaster;
    private GaragePlace assignedGaragePlace;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public enum OrderStatus {
        CREATED,
        COMPLETED,
        CANCELLED
    }

    public Order(String description, Master assignedMaster, GaragePlace assignedGaragePlace, LocalDateTime startTime, int durationInHours) {
        this.idOrder++;
        this.statusOrder = OrderStatus.CREATED;
        this.description = description;
        this.assignedMaster = assignedMaster;
        this.assignedGaragePlace = assignedGaragePlace;
        this.startTime = startTime;
        this.endTime = startTime.plusHours(durationInHours);
    }

    public int getIdOrder() {
        return this.idOrder;
    }

    public OrderStatus getStatusOrder() {
        return this.statusOrder;
    }

    public void setStatusOrder(OrderStatus statusOrder) {
        this.statusOrder = statusOrder;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Master getAssignedMaster() {
        return this.assignedMaster;
    }

    public GaragePlace getAssignedGaragePlace() {
        return this.assignedGaragePlace;
    }

    public LocalDateTime getStartTime() {
        return this.startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return this.endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return String.format("Order{idOrder=%d, statusOrder=%s, description='%s', assignedMaster=%s, assignedGaragePlace=%s, startTime=%s, endTime=%s}",
                idOrder, statusOrder, description, assignedMaster.getName(), assignedGaragePlace.getPlaceNumber(), startTime, endTime);
    }
}