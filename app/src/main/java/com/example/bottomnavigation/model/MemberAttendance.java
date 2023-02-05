package com.example.bottomnavigation.model;

public class MemberAttendance {
    long memberAttendanceId;
    String memberName;
    String punchDate;
    String punchInTime;
    String punchOutTime;
    String ownerId;

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public MemberAttendance(String memberName, String punchDate, String punchInTime, String punchOutTime) {
        this.memberName = memberName;
        this.punchDate = punchDate;
        this.punchInTime = punchInTime;
        this.punchOutTime = punchOutTime;
    }

    public long getMemberAttendanceId() {
        return memberAttendanceId;
    }

    public void setMemberAttendanceId(long memberAttendanceId) {
        this.memberAttendanceId = memberAttendanceId;
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
