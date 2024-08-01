package autoservice.models;

import java.time.LocalDateTime;

public class Order {
    private static int idCounter = 0;
    private int idOrder;
    private boolean isCompleted;
    private String description;
    private Master assignedMaster;
    private GaragePlace assignedGaragePlace;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Order(String description, Master assignedMaster, GaragePlace assignedGaragePlace, LocalDateTime startTime, int durationInHours) {
        this.idOrder = ++idCounter;
        this.isCompleted = false;
        this.description = description;
        this.assignedMaster = assignedMaster;
        this.assignedGaragePlace = assignedGaragePlace;
        this.startTime = startTime;
        this.endTime = startTime.plusHours(durationInHours);
    }

    public int getIdOrder() {
        return idOrder;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Master getAssignedMaster() {
        return assignedMaster;
    }

    public GaragePlace getAssignedGaragePlace() {
        return assignedGaragePlace;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return String.format("Order{idOrder=%d, isCompleted=%b, description='%s', assignedMaster=%s, assignedGaragePlace=%s, startTime=%s, endTime=%s}",
                idOrder, isCompleted, description, assignedMaster.getName(), assignedGaragePlace.getPlaceNumber(), startTime, endTime);
    }
}