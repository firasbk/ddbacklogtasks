package com.task.ddd.entity;

public class ReleaseID extends ConcurrencySafeEntity{
    ReleaseID releaseID;
    public ReleaseID getReleaseID() {
        return this.releaseID;
    }
}