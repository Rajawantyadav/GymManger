package com.example.bottomnavigation.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottomnavigation.R;
import com.example.bottomnavigation.adapters.MemberListAdapter;
import com.example.bottomnavigation.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MembersActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Member> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_members);
        recyclerView = findViewById(R.id.members_recyclerview);
        dataList.add(new Member("Chelsea", "12-01-2023", "Diwali", "12-03-2023"));
        dataList.add(new Member("Chelsea", "12-01-2023", "Diwali", "12-03-2023"));
        dataList.add(new Member("Chelsea", "12-01-2023", "Diwali", "12-03-2023"));
        dataList.add(new Member("Chelsea", "12-01-2023", "Diwali", "12-03-2023"));
        dataList.add(new Member("Chelsea", "12-01-2023", "Diwali", "12-03-2023"));
        dataList.add(new Member("Chelsea", "12-01-2023", "Diwali", "12-03-2023"));
        dataList.add(new Member("Chelsea", "12-01-2023", "Diwali", "12-03-2023"));
        dataList.add(new Member("Chelsea", "12-01-2023", "Diwali", "12-03-2023"));
        dataList.add(new Member("Chelsea", "12-01-2023", "Diwali", "12-03-2023"));
        dataList.add(new Member("Chelsea", "12-01-2023", "Diwali", "12-03-2023"));
        dataList.add(new Member("Chelsea", "12-01-2023", "Diwali", "12-03-2023"));
        dataList.add(new Member("Chelsea", "12-01-2023", "Diwali", "12-03-2023"));
        dataList.add(new Member("Chelsea", "12-01-2023", "Diwali", "12-03-2023"));
        dataList.add(new Member("Chelsea", "12-01-2023", "Diwali", "12-03-2023"));
        dataList.add(new Member("Chelsea", "12-01-2023", "Diwali", "12-03-2023"));
        dataList.add(new Member("Chelsea", "12-01-2023", "Diwali", "12-03-2023"));
        dataList.add(new Member("Chelsea", "12-01-2023", "Diwali", "12-03-2023"));
        dataList.add(new Member("Chelsea", "12-01-2023", "Diwali", "12-03-2023"));
        MemberListAdapter adapter = new MemberListAdapter(getApplicationContext(), dataList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(MembersActivity.this));


    }
}