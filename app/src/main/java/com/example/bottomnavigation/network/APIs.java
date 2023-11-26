package com.example.bottomnavigation.network;

public interface APIs {

    String ADD_MEMBER_URL="addMember";
    String ADD_BATCH_URL="addBatch";
    String ADD_PLAN_URL="addPlan";
    String ADD_GYM_OWNER_URL="addGymOwner";
    String ADD_ENQUIRY_MEMBER_URL="addEnquiryMember";
    String ADD_EXPENSE_URL="addExpense";
    String GET_MEMBERS_URL="getMembers/{ownerId}";
    String GET_BATCH_URL="getBatch/{ownerId}";
    String GET_PLAN_URL="getPlan/{ownerId}";
    String GET_GYM_OWNER_URL="getGymOwner/{ownerId}";
    String GET_ENQUIRY_MEMBER_URL="getEnquiryMembers/{ownerId}";
    String GET_OWNER_ATTENDANCE_URL="getAttendance/{ownerId}";
    String UPDATE_PLAN_URL="updatePlan";
    String UPDATE_BATCH_URL="updateBatch";
    String UPDATE_GYM_OWNER_URL="updateGymOwner";
    String LOGIN_URL="login";

}
