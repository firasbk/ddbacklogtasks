package com.task.ddd.entity;

public class SprintID extends ConcurrencySafeEntity{
    String id;
    public SprintID(String sprintID) {
        this.id = sprintID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}