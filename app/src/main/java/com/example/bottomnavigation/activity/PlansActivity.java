package com.example.bottomnavigation.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.bottomnavigation.R;
import com.example.bottomnavigation.adapters.PlanAdapter;
import com.example.bottomnavigation.model.Plan;
import com.example.bottomnavigation.network.ApiAgent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlansActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Button addPlanBtn;

    List<Plan> dataList = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plans);
        recyclerView = findViewById(R.id.recyclerView);
        addPlanBtn = findViewById(R.id.button_addPlan);

        try {
            Call<List<Plan>> planCall = ApiAgent.getAPIInstance().getApi().getPlans();
            planCall.enqueue(new Callback<List<Plan>>() {
                @Override
                public void onResponse(Call<List<Plan>> call, Response<List<Plan>> response) {
                    dataList.addAll(response.body());
                    PlanAdapter adapter = new PlanAdapter(PlansActivity.this, dataList);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(
                            new LinearLayoutManager(PlansActivity.this));
                }

                @Override
                public void onFailure(Call<List<Plan>> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Something went wrong...", Toast.LENGTH_SHORT);

                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }


        //adding click even on addPlan button

        addPlanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getApplicationContext(), AddNewPlanActivity.class);
                startActivity(myIntent);
            }
        });
    }
}