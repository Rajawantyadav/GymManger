package com.example.bottomnavigation.model;

public class Member {

    long memberId;
    String memberName;
    String joiningDate;
    String activePlanName;
    String planExpireDate;
    String ownerId;

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public Member(String memberName, String joiningDate, String activePlanName, String planExpireDate) {
        this.memberName = memberName;
        this.joiningDate = joiningDate;
        this.activePlanName = activePlanName;
        this.planExpireDate = planExpireDate;
    }



    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
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
