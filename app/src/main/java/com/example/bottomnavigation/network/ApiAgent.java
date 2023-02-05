package com.example.bottomnavigation.network;

import java.io.IOException;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiAgent {

    //private static final String BASE_URL = "https://api.publicapis.org/";
    //private static final String BASE_URL = "http://10.0.2.2:8080/api/";
    //private static final String BASE_URL = "http://192.168.114.100:8080/api/";
    //private static final String BASE_URL = "http://192.168.43.115:8080/api/";
    private static final String BASE_URL = "http://192.168.95.103:8080/api/";
    private static ApiAgent apiAgent;
    private static Retrofit retrofit;

    public ApiAgent() {
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static ApiAgent getAPIInstance() {
        if (apiAgent == null) {
            apiAgent = new ApiAgent();
        }
        return apiAgent;
    }

    public ApiInterface getApi() throws IOException {
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        return apiInterface;

    }

}
