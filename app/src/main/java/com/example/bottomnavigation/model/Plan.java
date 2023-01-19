package com.example.bottomnavigation.model;

public class Plan {
    String planName;
    String planPrice;
    String planDuration;
    String planDescription;

    public Plan(String planName, String planPrice, String planDuration, String planDescription) {
        this.planName = planName;
        this.planPrice = planPrice;
        this.planDuration = planDuration;
        this.planDescription = planDescription;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getPlanPrice() {
        return planPrice;
    }

    public void setPlanPrice(String planPrice) {
        this.planPrice = planPrice;
    }

    public String getPlanDuration() {
        return planDuration;
    }

    public void setPlanDuration(String planDuration) {
        this.planDuration = planDuration;
    }

    public String getPlanDescription() {
        return planDescription;
    }

    public void setPlanDescription(String planDescription) {
        this.planDescription = planDescription;
    }
}
