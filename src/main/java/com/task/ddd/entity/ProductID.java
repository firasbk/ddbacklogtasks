package com.task.ddd.entity;

public class ProductID extends ConcurrencySafeEntity{
    String id;
    public ProductID(String teamMemberId) {
        this.id = teamMemberId;
    }
}
