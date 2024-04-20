package com.task.ddd.entity;

public class EstimationLogEntry extends ConcurrencySafeEntity{
    String name;
    String description;
    Integer hourRemaining;
    String volunteer;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getHourRemaining() {
        return hourRemaining;
    }

    public void setHourRemaining(Integer hourRemaining) {
        this.hourRemaining = hourRemaining;
    }

    public String getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(String volunteer) {
        this.volunteer = volunteer;
    }
}
