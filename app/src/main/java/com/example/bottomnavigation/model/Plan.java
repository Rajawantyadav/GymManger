package com.example.bottomnavigation.model;

public class Plan {
    String planId;
    String planName;
    String planPrice;
    String planDuration;
    String planDescription;
    String planAcive;
    String ownerId;

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public Plan() {
    }

    public Plan(String planName, String planPrice, String planDuration, String planDescription) {
        this.planName = planName;
        this.planPrice = planPrice;
        this.planDuration = planDuration;
        this.planDescription = planDescription;

    }

    public Plan(String planName, String planPrice, String planDuration, String planDescription, String active) {
        this.planName = planName;
        this.planPrice = planPrice;
        this.planDuration = planDuration;
        this.planDescription = planDescription;
        this.planAcive = active;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getPlanAcive() {
        return planAcive;
    }

    public void setPlanAcive(String planAcive) {
        this.planAcive = planAcive;
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
