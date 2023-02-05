package com.example.bottomnavigation.model;

public class EnquiryMember {
    String member_id;
    String member_name;
    String member_email;
    String member_mobile;
    String member_gender;
    String enquiry_date;
    String enquiry_desc;
    String ownerId;

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public String getMember_email() {
        return member_email;
    }

    public void setMember_email(String member_email) {
        this.member_email = member_email;
    }

    public String getMember_mobile() {
        return member_mobile;
    }

    public void setMember_mobile(String member_mobile) {
        this.member_mobile = member_mobile;
    }

    public String getMember_gender() {
        return member_gender;
    }

    public void setMember_gender(String member_gender) {
        this.member_gender = member_gender;
    }

    public String getEnquiry_date() {
        return enquiry_date;
    }

    public void setEnquiry_date(String enquiry_date) {
        this.enquiry_date = enquiry_date;
    }

    public String getEnquiry_desc() {
        return enquiry_desc;
    }

    public void setEnquiry_desc(String enquiry_desc) {
        this.enquiry_desc = enquiry_desc;
    }
}
