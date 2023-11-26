package com.example.bottomnavigation.response;

import com.example.bottomnavigation.model.EnquiryMember;

import java.util.List;


public class EnquiryResp {
    private String error;
    private String msg;
    private List<EnquiryMember> enquiryMembers;
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

    public List<EnquiryMember> getEnquiryMembers() {
        return enquiryMembers;
    }

    public void setEnquiryMembers(List<EnquiryMember> enquiryMembers) {
        this.enquiryMembers = enquiryMembers;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
}
