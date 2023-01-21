package com.example.bottomnavigation.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottomnavigation.R;
import com.example.bottomnavigation.adapters.MemberAttendanceAdapter;
import com.example.bottomnavigation.model.MemberAttendance;
import com.example.bottomnavigation.network.ApiAgent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AttendanceActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<MemberAttendance> dataList = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        recyclerView = findViewById(R.id.attendance_recyclerview);
        try {
            Call<List<MemberAttendance>> attendanceCall = ApiAgent.getAPIInstance().getApi().getAttendance();
            attendanceCall.enqueue(new Callback<List<MemberAttendance>>() {
                @Override
                public void onResponse(Call<List<MemberAttendance>> call, Response<List<MemberAttendance>> response) {
                    dataList.addAll(response.body());
                    MemberAttendanceAdapter adapter = new MemberAttendanceAdapter(getApplicationContext(), dataList);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(
                            new LinearLayoutManager(AttendanceActivity.this));
                }

                @Override
                public void onFailure(Call<List<MemberAttendance>> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Something went wrong...", Toast.LENGTH_SHORT);
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}