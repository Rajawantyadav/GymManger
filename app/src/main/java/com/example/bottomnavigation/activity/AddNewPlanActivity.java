package com.example.bottomnavigation.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bottomnavigation.R;
import com.example.bottomnavigation.activity.PlansActivity;
import com.example.bottomnavigation.model.Plan;
import com.example.bottomnavigation.network.ApiAgent;
import com.example.bottomnavigation.response.MemberAddResp;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddNewPlanActivity extends AppCompatActivity {
    TextView planDuration, planFees, planDesc, planName, add_plan_title;
    RadioButton radioMonths, radioDays;
    Button btnAddPlan;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_plan);
        planName = findViewById(R.id.add_plan_name);
        add_plan_title = findViewById(R.id.add_plan_title);
        planFees = findViewById(R.id.add_plan_fees);
        planDesc = findViewById(R.id.add_plan_description);
        planDuration = findViewById(R.id.add_plan_duration);
        radioMonths = findViewById(R.id.plan_radio_months);
        radioDays = findViewById(R.id.plan_radio_days);
        btnAddPlan = findViewById(R.id.add_plan_btn);
        Intent intent = getIntent();
       String ownerId = intent.getStringExtra("ownerId");

        btnAddPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String durationInDays = null;
                if (radioMonths.isChecked()) {
                    durationInDays = Integer.parseInt(planDuration.getText().toString()) * 30 + "";
                } else if (radioDays.isChecked()) {
                    durationInDays = planDuration.getText().toString();
                }
                if (planName.getText().length() == 0 || planFees.getText().length() == 0 || planDesc.getText().length() == 0
                        || planDuration.getText().length() == 0 || durationInDays.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please fill all the required fields..", Toast.LENGTH_SHORT).show();
                } else {
                    Plan plan = new Plan();
                    plan.setPlanName(planName.getText().toString());
                    plan.setPlanPrice(planFees.getText().toString());
                    plan.setPlanDescription(planDesc.getText().toString());
                    plan.setPlanDuration(durationInDays);
                    plan.setPlanAcive("1");
                    plan.setOwnerId(ownerId);
                    try {
                        Call<MemberAddResp> addPlanCall = ApiAgent.getAPIInstance().getApi().addPlan(plan);
                        addPlanCall.enqueue(new Callback<MemberAddResp>() {
                            @Override
                            public void onResponse(Call<MemberAddResp> call, Response<MemberAddResp> response) {
                                Toast.makeText(getApplicationContext(), response.body().getMsg(), Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), PlansActivity.class);
                                intent.putExtra("ownerId",ownerId);
                                startActivity(intent);
                            }

                            @Override
                            public void onFailure(Call<MemberAddResp> call, Throwable t) {
                                Toast.makeText(getApplicationContext(), "Something went Wrong..??", Toast.LENGTH_SHORT).show();
                            }
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


            }
        });

    }
}