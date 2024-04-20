package com.task.ddd.entity;

import java.util.List;

public class Task extends ConcurrencySafeEntity{
    String id;
    String name;
    String description;
    Integer hourRemaining;
    String volunteer;
    List<EstimationLogEntry> estimationLogEntries;

    public Task(String taskId) {
        this.id = taskId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public List<EstimationLogEntry> getEstimationLogEntries() {
        return estimationLogEntries;
    }

    public void setEstimationLogEntries(List<EstimationLogEntry> estimationLogEntries) {
        this.estimationLogEntries = estimationLogEntries;
    }
}
