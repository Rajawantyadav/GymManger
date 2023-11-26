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
import com.example.bottomnavigation.listener.SelectListener;
import com.example.bottomnavigation.model.Plan;
import com.example.bottomnavigation.network.ApiAgent;
import com.example.bottomnavigation.response.PlanResp;

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
    SelectListener listener;
    String ownerId;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plans);
        recyclerView = findViewById(R.id.recyclerView);
        addPlanBtn = findViewById(R.id.button_addPlan);
        Intent intent = getIntent();
        ownerId = intent.getStringExtra("ownerId");

        try {
            Call<PlanResp> planCall = ApiAgent.getAPIInstance().getApi().getPlans(ownerId);
            planCall.enqueue(new Callback<PlanResp>() {
                @Override
                public void onResponse(Call<PlanResp> call, Response<PlanResp> response) {
                    if (response != null && response.body() != null && response.body().getPlans() != null)
                        dataList.addAll(response.body().getPlans());
                    listener = new SelectListener() {
                        @Override
                        public void onItemClickListener(Object object) {
                            Plan plan = (Plan) object;
                            Intent intent = new Intent(getApplicationContext(), EditPlanActivity.class);
                            intent.putExtra("plan_id", plan.getPlanId());
                            intent.putExtra("plan_name", plan.getPlanName());
                            intent.putExtra("plan_price", plan.getPlanPrice());
                            intent.putExtra("plan_duration", plan.getPlanDuration());
                            intent.putExtra("plan_desc", plan.getPlanDescription());
                            startActivity(intent);
                        }
                    };
                    PlanAdapter adapter = new PlanAdapter(PlansActivity.this, dataList, listener);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(
                            new LinearLayoutManager(PlansActivity.this));


                }

                @Override
                public void onFailure(Call<PlanResp> call, Throwable t) {
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
                myIntent.putExtra("ownerId", ownerId);
                startActivity(myIntent);
            }
        });
    }
}