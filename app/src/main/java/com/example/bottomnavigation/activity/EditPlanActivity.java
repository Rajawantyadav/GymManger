package com.example.bottomnavigation.activity;

import androidx.appcompat.app.AppCompatActivity;

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

public class EditPlanActivity extends AppCompatActivity {
    TextView planDuration, planFees, planDesc, planName;
    RadioButton radioMonths, radioDays;
    Button btnSavePlan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_plan);

        planName = findViewById(R.id.add_plan_name);
        planFees = findViewById(R.id.add_plan_fees);
        planDesc = findViewById(R.id.add_plan_description);
        planDuration = findViewById(R.id.add_plan_duration);
        radioMonths = findViewById(R.id.plan_radio_months);
        radioDays = findViewById(R.id.plan_radio_days);
        btnSavePlan = findViewById(R.id.add_plan_btn);
        Intent intent = getIntent();
        String plan_id = intent.getStringExtra("plan_id");
        String plan_name = intent.getStringExtra("plan_name");
        String plan_price = intent.getStringExtra("plan_price");
        String plan_duration = intent.getStringExtra("plan_duration");
        String plan_desc = intent.getStringExtra("plan_desc");
        planName.setText(plan_name);
        planFees.setText(plan_price);
        planDesc.setText(plan_desc);
        radioDays.setChecked(true);
        planDuration.setText(plan_duration);
        btnSavePlan.setOnClickListener(new View.OnClickListener() {
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
                    plan.setPlanId(plan_id);
                    plan.setPlanName(planName.getText().toString());
                    plan.setPlanPrice(planFees.getText().toString());
                    plan.setPlanDescription(planDesc.getText().toString());
                    plan.setPlanDuration(durationInDays);
                    plan.setPlanAcive("1");
                    try {
                        Call<MemberAddResp> updatePlanCall = ApiAgent.getAPIInstance().getApi().updatePlans(plan);
                        updatePlanCall.enqueue(new Callback<MemberAddResp>() {
                            @Override
                            public void onResponse(Call<MemberAddResp> call, Response<MemberAddResp> response) {
                                Toast.makeText(getApplicationContext(), response.body().getMsg(), Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), PlansActivity.class);
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