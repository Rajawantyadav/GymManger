package com.example.bottomnavigation.network;


import com.example.bottomnavigation.request.MemberDetails;
import com.example.bottomnavigation.response.MemberAddResp;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("addMember")
    Call<MemberAddResp> addMember(@Body MemberDetails details);

}
