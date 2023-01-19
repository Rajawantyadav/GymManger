package com.example.bottomnavigation.model;

public class MemberAttendance {
    String memberName;
    String punchDate;
    String punchInTime;
    String punchOutTime;

    public MemberAttendance(String memberName, String punchDate, String punchInTime, String punchOutTime) {
        this.memberName = memberName;
        this.punchDate = punchDate;
        this.punchInTime = punchInTime;
        this.punchOutTime = punchOutTime;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getPunchDate() {
        return punchDate;
    }

    public void setPunchDate(String punchDate) {
        this.punchDate = punchDate;
    }

    public String getPunchInTime() {
        return punchInTime;
    }

    public void setPunchInTime(String punchInTime) {
        this.punchInTime = punchInTime;
    }

    public String getPunchOutTime() {
        return punchOutTime;
    }

    public void setPunchOutTime(String punchOutTime) {
        this.punchOutTime = punchOutTime;
    }
}
