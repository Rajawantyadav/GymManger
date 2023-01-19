package com.example.bottomnavigation.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bottomnavigation.AddNewPlanActivity;
import com.example.bottomnavigation.R;
import com.example.bottomnavigation.adapters.PlanAdapter;
import com.example.bottomnavigation.model.Plan;

import java.util.ArrayList;
import java.util.List;

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
        dataList.add(new Plan("Diwali Plan", "2000", "2 Months", "Diwali Plan is been added .."));
        dataList.add(new Plan("Holi Plan", "2000", "2 Months", "Diwali Plan is been added .."));
        dataList.add(new Plan("Holi Plan", "2000", "2 Months", "Diwali Plan is been added .."));
        dataList.add(new Plan("Holi Plan", "2000", "2 Months", "Diwali Plan is been added .."));
        PlanAdapter adapter = new PlanAdapter(PlansActivity.this, dataList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(PlansActivity.this));

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