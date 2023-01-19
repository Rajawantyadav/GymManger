package com.example.bottomnavigation.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.bottomnavigation.R;
import com.example.bottomnavigation.adapters.MemberAttendanceAdapter;
import com.example.bottomnavigation.model.MemberAttendance;

import java.util.ArrayList;
import java.util.List;

public class AttendanceActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<MemberAttendance> dataList = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        recyclerView = findViewById(R.id.attendance_recyclerview);
        dataList.add(new MemberAttendance("Rajawant yadav", "12-01-2023", "12:30 AM", "1:30PM"));
        dataList.add(new MemberAttendance("Rajawant yadav", "12-01-2023", "12:30 AM", "1:30PM"));
        dataList.add(new MemberAttendance("Rajawant yadav", "12-01-2023", "12:30 AM", "1:30PM"));
        dataList.add(new MemberAttendance("Rajawant yadav", "12-01-2023", "12:30 AM", "1:30PM"));
        dataList.add(new MemberAttendance("Rajawant yadav", "12-01-2023", "12:30 AM", "1:30PM"));
        dataList.add(new MemberAttendance("Rajawant yadav", "12-01-2023", "12:30 AM", "1:30PM"));
        dataList.add(new MemberAttendance("Rajawant yadav", "12-01-2023", "12:30 AM", "1:30PM"));
        dataList.add(new MemberAttendance("Rajawant yadav", "12-01-2023", "12:30 AM", "1:30PM"));
        dataList.add(new MemberAttendance("Rajawant yadav", "12-01-2023", "12:30 AM", "1:30PM"));
        dataList.add(new MemberAttendance("Rajawant yadav", "12-01-2023", "12:30 AM", "1:30PM"));
        dataList.add(new MemberAttendance("Rajawant yadav", "12-01-2023", "12:30 AM", "1:30PM"));
        dataList.add(new MemberAttendance("Rajawant yadav", "12-01-2023", "12:30 AM", "1:30PM"));
        dataList.add(new MemberAttendance("Rajawant yadav", "12-01-2023", "12:30 AM", "1:30PM"));
        dataList.add(new MemberAttendance("Rajawant yadav", "12-01-2023", "12:30 AM", "1:30PM"));
        dataList.add(new MemberAttendance("Rajawant yadav", "12-01-2023", "12:30 AM", "1:30PM"));
        dataList.add(new MemberAttendance("Rajawant yadav", "12-01-2023", "12:30 AM", "1:30PM"));
        dataList.add(new MemberAttendance("Rajawant yadav", "12-01-2023", "12:30 AM", "1:30PM"));
        dataList.add(new MemberAttendance("Rajawant yadav", "12-01-2023", "12:30 AM", "1:30PM"));
        dataList.add(new MemberAttendance("Rajawant yadav", "12-01-2023", "12:30 AM", "1:30PM"));
        dataList.add(new MemberAttendance("Rajawant yadav", "12-01-2023", "12:30 AM", "1:30PM"));
        dataList.add(new MemberAttendance("Rajawant yadav", "12-01-2023", "12:30 AM", "1:30PM"));
        dataList.add(new MemberAttendance("Rajawant yadav", "12-01-2023", "12:30 AM", "1:30PM"));
        dataList.add(new MemberAttendance("Rajawant yadav", "12-01-2023", "12:30 AM", "1:30PM"));
        dataList.add(new MemberAttendance("Rajawant yadav", "12-01-2023", "12:30 AM", "1:30PM"));
        MemberAttendanceAdapter adapter = new MemberAttendanceAdapter(getApplicationContext(), dataList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(AttendanceActivity.this));

    }
}