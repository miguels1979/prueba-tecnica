package com.tektonlabs.percentageprovider.dtos;

public class PercentageResponse {

    private double percentage;

    public PercentageResponse(double percentage) {
        this.percentage = percentage;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}
