package com.task.ddd.entity;

import java.util.List;
import java.util.UUID;

public class Backlog extends ConcurrencySafeEntity{
    UUID id ;
    String name;
    String description;

    List<BacklogItem> backlogItems;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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

    public List<BacklogItem> getBacklogItems() {
        return backlogItems;
    }

    public void setBacklogItems(List<BacklogItem> backlogItems) {
        this.backlogItems = backlogItems;
    }
}
