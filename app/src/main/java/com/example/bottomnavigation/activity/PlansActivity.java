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


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plans);
        recyclerView = findViewById(R.id.recyclerView);
        addPlanBtn = findViewById(R.id.button_addPlan);
       String ownerId="1";
        try {
            Call<List<Plan>> planCall = ApiAgent.getAPIInstance().getApi().getPlans(ownerId);
            planCall.enqueue(new Callback<List<Plan>>() {
                @Override
                public void onResponse(Call<List<Plan>> call, Response<List<Plan>> response) {
                    dataList.addAll(response.body());
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