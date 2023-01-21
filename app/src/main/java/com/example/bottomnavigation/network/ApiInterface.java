package com.example.bottomnavigation.network;


import com.example.bottomnavigation.model.Batch;
import com.example.bottomnavigation.model.Member;
import com.example.bottomnavigation.model.MemberAttendance;
import com.example.bottomnavigation.model.Plan;
import com.example.bottomnavigation.request.MemberDetails;
import com.example.bottomnavigation.response.MemberAddResp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("addMember")
    Call<MemberAddResp> addMember(@Body MemberDetails memberDetails);

    @POST("addBatch")
    Call<MemberAddResp> addBatch(@Body Batch batchDetails);

    @POST("addPlan")
    Call<MemberAddResp> addPlan(@Body Plan planDetails);

    @GET("getAttendance")
    Call<List<MemberAttendance>> getAttendance();

    @GET("getMembers")
    Call<List<Member>> getMembers();

    @GET("getBatch")
    Call<List<Batch>> getBatches();

    @GET("getPlan")
    Call<List<Plan>> getPlans();

}
