package com.example.bottomnavigation.request;

public class MemberDetails {
    String memberName;
    String memberEmail;
    String memberMobile;
    String memberDob;
    String memberGender;
    String memberBatch;
    String memberPlan;
    String memberWeight;
    String ownerId;

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public MemberDetails() {
    }

    public MemberDetails(String memberName, String memberEmail, String memberMobile, String memberDob, String memberGender, String memberBatch, String memberPlan, String memberWeight) {
        this.memberName = memberName;
        this.memberEmail = memberEmail;
        this.memberMobile = memberMobile;
        this.memberDob = memberDob;
        this.memberGender = memberGender;
        this.memberBatch = memberBatch;
        this.memberPlan = memberPlan;
        this.memberWeight = memberWeight;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public String getMemberMobile() {
        return memberMobile;
    }

    public void setMemberMobile(String memberMobile) {
        this.memberMobile = memberMobile;
    }

    public String getMemberDob() {
        return memberDob;
    }

    public void setMemberDob(String memberDob) {
        this.memberDob = memberDob;
    }

    public String getMemberGender() {
        return memberGender;
    }

    public void setMemberGender(String memberGender) {
        this.memberGender = memberGender;
    }

    public String getMemberBatch() {
        return memberBatch;
    }

    public void setMemberBatch(String memberBatch) {
        this.memberBatch = memberBatch;
    }

    public String getMemberPlan() {
        return memberPlan;
    }

    public void setMemberPlan(String memberPlan) {
        this.memberPlan = memberPlan;
    }

    public String getMemberWeight() {
        return memberWeight;
    }

    public void setMemberWeight(String memberWeight) {
        this.memberWeight = memberWeight;
    }
}
