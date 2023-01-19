package com.example.bottomnavigation.model;

public class Member {
    String memberName;
    String joiningDate;
    String activePlanName;
    String planExpireDate;

    public Member(String memberName, String joiningDate, String activePlanName, String planExpireDate) {
        this.memberName = memberName;
        this.joiningDate = joiningDate;
        this.activePlanName = activePlanName;
        this.planExpireDate = planExpireDate;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getActivePlanName() {
        return activePlanName;
    }

    public void setActivePlanName(String activePlanName) {
        this.activePlanName = activePlanName;
    }

    public String getPlanExpireDate() {
        return planExpireDate;
    }

    public void setPlanExpireDate(String planExpireDate) {
        this.planExpireDate = planExpireDate;
    }
}
