package com.appd.simple.servlet.simpleservlet.restservice;

import java.util.Random;

public class SomeClassXD {
    private int applicationId;
    private int microApplicationId;

    public SomeClassXD() {
        this.applicationId = new Random().nextInt(10);
        this.microApplicationId = new Random().nextInt(10) + 100;
    }

    public int getMicroApplicationId() {
        return microApplicationId;
    }

    public SomeClassXD setMicroApplicationId(int microApplicationId) {
        this.microApplicationId = microApplicationId;
        return this;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public SomeClassXD setApplicationId(int applicationId) {
        this.applicationId = applicationId;
        return this;
    }
}
