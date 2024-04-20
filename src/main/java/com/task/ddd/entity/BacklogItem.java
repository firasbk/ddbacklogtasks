package com.task.ddd.entity;

import java.util.List;

public class BacklogItem extends ConcurrencySafeEntity{
    String id ;
    String status;
    String story;
    Integer storyPoints;
    String summary;
    String type;
    ProductID productID;
    ReleaseID releaseID;
    SprintID sprintID;

    List<Task> tasks;

    public SprintID sprintID() {
        return this.sprintID;
    }
    public ReleaseID releaseID() {
        return this.releaseID;
    }
    public ProductID productID() {
        return this.productID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public Integer getStoryPoints() {
        return storyPoints;
    }

    public void setStoryPoints(Integer storyPoints) {
        this.storyPoints = storyPoints;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ProductID getProductID() {
        return productID;
    }

    public void setProductID(ProductID productID) {
        this.productID = productID;
    }

    public ReleaseID getReleaseID() {
        return releaseID;
    }

    public void setReleaseID(ReleaseID releaseID) {
        this.releaseID = releaseID;
    }

    public SprintID getSprintID() {
        return sprintID;
    }

    public void setSprintID(SprintID sprintID) {
        this.sprintID = sprintID;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
