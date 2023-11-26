package com.example.bottomnavigation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottomnavigation.R;
import com.example.bottomnavigation.adapters.MemberListAdapter;
import com.example.bottomnavigation.model.Member;
import com.example.bottomnavigation.network.ApiAgent;
import com.example.bottomnavigation.response.MemberResp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MembersActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Member> dataList = new ArrayList<>();
    String ownerId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_members);
        recyclerView = findViewById(R.id.members_recyclerview);
        Intent intent=getIntent();
        ownerId=intent.getStringExtra("ownerId");


        try {
            Call<MemberResp> members = ApiAgent.getAPIInstance().getApi().getMembers(ownerId);
            members.enqueue(new Callback<MemberResp>() {
                @Override
                public void onResponse(Call<MemberResp> call, Response<MemberResp> response) {
                    dataList.addAll(response.body().getMemebers());
                    MemberListAdapter adapter = new MemberListAdapter(getApplicationContext(), dataList);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(
                            new LinearLayoutManager(MembersActivity.this));
                }

                @Override
                public void onFailure(Call<MemberResp> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Something went wrong ???.", Toast.LENGTH_SHORT).show();
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}