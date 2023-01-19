package com.example.bottomnavigation.model;

public class Batch {
    String batchName;
    String batchStartTime;
    String batchEndTime;
    String limit;

    public Batch(String batchName, String batchStartTime, String batchEndTime, String limit) {
        this.batchName = batchName;
        this.batchStartTime = batchStartTime;
        this.batchEndTime = batchEndTime;
        this.limit = limit;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public String getBatchStartTime() {
        return batchStartTime;
    }

    public void setBatchStartTime(String batchStartTime) {
        this.batchStartTime = batchStartTime;
    }

    public String getBatchEndTime() {
        return batchEndTime;
    }

    public void setBatchEndTime(String batchEndTime) {
        this.batchEndTime = batchEndTime;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }
}
