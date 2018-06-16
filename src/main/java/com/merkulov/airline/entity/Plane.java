package com.merkulov.airline.entity;

public class Plane extends AbstactEntity<Long> {
    private String name;
    private String model;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
