package com.example.bottomnavigation.response;

public class MemberAddResp {
    String error;
    String msg;

    public MemberAddResp() {
    }

    public MemberAddResp(String error, String msg) {
        this.error = error;
        this.msg = msg;
    }

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
}
