package com.example.bottomnavigation.activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottomnavigation.R;
import com.example.bottomnavigation.adapters.MemberListAdapter;
import com.example.bottomnavigation.model.Member;
import com.example.bottomnavigation.network.ApiAgent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MembersActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Member> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_members);
        recyclerView = findViewById(R.id.members_recyclerview);

        try {
            Call<List<Member>> members = ApiAgent.getAPIInstance().getApi().getMembers();
            members.enqueue(new Callback<List<Member>>() {
                @Override
                public void onResponse(Call<List<Member>> call, Response<List<Member>> response) {
                    Toast.makeText(getApplicationContext(), "Data Fetched succssFully..", Toast.LENGTH_SHORT).show();
                    dataList.addAll(response.body());
                    MemberListAdapter adapter = new MemberListAdapter(getApplicationContext(), dataList);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(
                            new LinearLayoutManager(MembersActivity.this));
                }

                @Override
                public void onFailure(Call<List<Member>> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Something went wrong ???.", Toast.LENGTH_SHORT).show();
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}