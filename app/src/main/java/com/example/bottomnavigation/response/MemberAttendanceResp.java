package com.example.bottomnavigation.response;

import com.example.bottomnavigation.model.MemberAttendance;

import java.util.List;


public class MemberAttendanceResp {
    private String error;
    private String msg;
    private List<MemberAttendance> memberAttendances;
    private String ownerId;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<MemberAttendance> getMemberAttendances() {
        return memberAttendances;
    }

    public void setMemberAttendances(List<MemberAttendance> memberAttendances) {
        this.memberAttendances = memberAttendances;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
}
