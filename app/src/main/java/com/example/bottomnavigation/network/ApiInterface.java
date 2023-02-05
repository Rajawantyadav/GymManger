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
import com.example.bottomnavigation.response.MemberAddResp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {

    @POST("addMember")
    Call<MemberAddResp> addMember(@Body MemberDetails memberDetails);

    @POST("addBatch")
    Call<MemberAddResp> addBatch(@Body Batch batchDetails);

    @POST("addPlan")
    Call<MemberAddResp> addPlan(@Body Plan planDetails);

    @GET("getAttendance/{ownerId}")
    Call<List<MemberAttendance>> getAttendance(@Path("ownerId") String ownerId);

    @GET("getMembers/{ownerId}")
    Call<List<Member>> getMembers(@Path("ownerId") String ownerId);

    @GET("getBatch/{ownerId}")
    Call<List<Batch>> getBatches(@Path("ownerId") String ownerId);

    @GET("getPlan/{ownerId}")
    Call<List<Plan>> getPlans(@Path("ownerId") String ownerId);

    @POST("updatePlan")
    Call<MemberAddResp> updatePlans(@Body Plan updatedPlan);

    @POST("updateBatch")
    Call<MemberAddResp> updateBatch(@Body Batch updatedBatch);

    @POST("login")
    Call<MemberAddResp> loginGymOwner(@Body LoginReq loginReq);

    @POST("addGymOwner")
    Call<MemberAddResp> addGymOwner(@Body GymOwner gymOwner);

    @POST("addEnquiryMember")
    Call<MemberAddResp> addEnquiryMember(@Body EnquiryMember enquiryMember);

    @POST("addExpense")
    Call<MemberAddResp> addExpense(@Body GymExpense gymExpense);


}
