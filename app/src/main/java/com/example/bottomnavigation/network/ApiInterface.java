package com.example.bottomnavigation.network;


import com.example.bottomnavigation.model.Batch;
import com.example.bottomnavigation.model.EnquiryMember;
import com.example.bottomnavigation.model.GymExpense;
import com.example.bottomnavigation.model.GymOwner;
import com.example.bottomnavigation.model.Member;
import com.example.bottomnavigation.model.MemberAttendance;
import com.example.bottomnavigation.model.Plan;
import com.example.bottomnavigation.request.LoginReq;
import com.example.bottomnavigation.request.MemberDetails;
import com.example.bottomnavigation.response.BatchResp;
import com.example.bottomnavigation.response.EnquiryResp;
import com.example.bottomnavigation.response.MemberAddResp;
import com.example.bottomnavigation.response.MemberResp;
import com.example.bottomnavigation.response.PlanResp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {

    @POST(APIs.ADD_MEMBER_URL)
    Call<MemberAddResp> addMember(@Body MemberDetails memberDetails);

    @POST(APIs.ADD_BATCH_URL)
    Call<MemberAddResp> addBatch(@Body Batch batchDetails);

    @POST(APIs.ADD_PLAN_URL)
    Call<MemberAddResp> addPlan(@Body Plan planDetails);

    @GET(APIs.GET_OWNER_ATTENDANCE_URL)
    Call<List<MemberAttendance>> getAttendance(@Path("ownerId") String ownerId);

    @GET(APIs.GET_MEMBERS_URL)
    Call<MemberResp> getMembers(@Path("ownerId") String ownerId);

    @GET(APIs.GET_BATCH_URL)
    Call<BatchResp> getBatches(@Path("ownerId") String ownerId);

    @GET(APIs.GET_PLAN_URL)
    Call<PlanResp> getPlans(@Path("ownerId") String ownerId);
    @GET(APIs.GET_GYM_OWNER_URL)
    Call<GymOwner> getGymOwner(@Path("ownerId") String ownerId);
    @GET(APIs.GET_ENQUIRY_MEMBER_URL)
    Call<EnquiryResp> getEnquiryMembers(@Path("ownerId") String ownerId);
    @POST(APIs.UPDATE_PLAN_URL)
    Call<MemberAddResp> updatePlans(@Body Plan updatedPlan);

    @POST(APIs.UPDATE_BATCH_URL)
    Call<MemberAddResp> updateBatch(@Body Batch updatedBatch);
    @POST(APIs.UPDATE_GYM_OWNER_URL)
    Call<MemberAddResp> updateGymOwner(@Body GymOwner gymOwner);

    @POST(APIs.LOGIN_URL)
    Call<MemberAddResp> loginGymOwner(@Body LoginReq loginReq);

    @POST(APIs.ADD_GYM_OWNER_URL)
    Call<MemberAddResp> addGymOwner(@Body GymOwner gymOwner);

    @POST(APIs.ADD_ENQUIRY_MEMBER_URL)
    Call<MemberAddResp> addEnquiryMember(@Body EnquiryMember enquiryMember);

    @POST(APIs.ADD_EXPENSE_URL)
    Call<MemberAddResp> addExpense(@Body GymExpense gymExpense);


}
