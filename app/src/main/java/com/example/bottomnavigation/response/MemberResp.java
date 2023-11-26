package com.example.bottomnavigation.response;

import com.example.bottomnavigation.model.Member;

import java.util.List;


public class MemberResp {
    private String error;
    private String msg;
    private List<Member> memebers;
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

    public List<Member> getMemebers() {
        return memebers;
    }

    public void setMemebers(List<Member> memebers) {
        this.memebers = memebers;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
}
