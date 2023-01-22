package com.example.bottomnavigation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bottomnavigation.R;
import com.example.bottomnavigation.model.Batch;
import com.example.bottomnavigation.model.Plan;
import com.example.bottomnavigation.network.ApiAgent;
import com.example.bottomnavigation.request.MemberDetails;
import com.example.bottomnavigation.response.MemberAddResp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddNewUserActivity extends AppCompatActivity {
    TextView name, email, mobile, dob, weight;
    RadioButton radioMale, radioFemale;
    Spinner batchNameSpinner, planNameSpinner;
    Button addButton;
    ArrayList<String> batchList;
    ArrayList<String> planList;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_user);
        name = findViewById(R.id.add_name);
        email = findViewById(R.id.add_email);
        mobile = findViewById(R.id.add_mobile);
        dob = findViewById(R.id.add_dob);
        weight = findViewById(R.id.add_weight);
        radioFemale = findViewById(R.id.add_radio_female);
        radioMale = findViewById(R.id.add_radio_male);
        batchNameSpinner = findViewById(R.id.batch_spinner);
        planNameSpinner = findViewById(R.id.plan_spinner);
        addButton = findViewById(R.id.add_button);
        batchList = getBatch();
        planList = getPlan();
     /* batchList = new ArrayList<>();
        batchList.add("Evening Batch");
        batchList.add("Morning Batch");
        planList = new ArrayList<>();
        planList.add("Monthly Plan");
        planList.add("Yearly Plan");*/
        // Application of the Array to the Spinner
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, batchList);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        batchNameSpinner.setAdapter(spinnerArrayAdapter);
        batchNameSpinner.setSelection(1);


        // Application of the Array to the Spinner
        ArrayAdapter<String> spinnerArrayAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, planList);
        spinnerArrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        planNameSpinner.setAdapter(spinnerArrayAdapter1);
        planNameSpinner.setSelection(1);


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    String gender = null;
                    if (radioFemale.isChecked()) {
                        gender = radioFemale.getText().toString();

                    } else if (radioMale.isChecked()) {
                        gender = radioMale.getText().toString();
                    }
                    MemberDetails memberDetails = new MemberDetails();
                    memberDetails.setMemberName(name.getText().toString());
                    memberDetails.setMemberEmail(email.getText().toString());
                    memberDetails.setMemberMobile(mobile.getText().toString());
                    memberDetails.setMemberDob(dob.getText().toString());
                    memberDetails.setMemberWeight(weight.getText().toString());
                    memberDetails.setMemberGender(gender);
                    Call<MemberAddResp> respCall = ApiAgent.getAPIInstance().getApi().addMember(memberDetails);
                    respCall.enqueue(new Callback<MemberAddResp>() {
                        @Override
                        public void onResponse(Call<MemberAddResp> call, Response<MemberAddResp> response) {

                            if (response.isSuccessful() && response.body().getError().equalsIgnoreCase("false")) {
                                Toast.makeText(getApplicationContext(), response.body().getMsg() + "", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(AddNewUserActivity.this, MembersActivity.class);
                                startActivity(intent);
                            }

                        }

                        @Override
                        public void onFailure(Call<MemberAddResp> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "Something went wrong...", Toast.LENGTH_SHORT).show();
                        }
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


    }

    private ArrayList<String> getBatch() {
        ArrayList<Batch> batchList = new ArrayList<>();
        ArrayList<String> baches = new ArrayList<>();
        try {
            Call<List<Batch>> batchCall = ApiAgent.getAPIInstance().getApi().getBatches();
            batchCall.enqueue(new Callback<List<Batch>>() {
                @Override
                public void onResponse(Call<List<Batch>> call, Response<List<Batch>> response) {
                    batchList.addAll(response.body());
                    for (Batch batch : batchList) {
                        baches.add(batch.getBatchName());
                    }
                }

                @Override
                public void onFailure(Call<List<Batch>> call, Throwable t) {

                }
            });


        } catch (Exception e) {

        }
        return baches;
    }

    private ArrayList<String> getPlan() {
        ArrayList<Plan> planList = new ArrayList<>();
        ArrayList<String> plans = new ArrayList<>();
        try {
            Call<List<Plan>> planCall = ApiAgent.getAPIInstance().getApi().getPlans();
            planCall.enqueue(new Callback<List<Plan>>() {
                @Override
                public void onResponse(Call<List<Plan>> call, Response<List<Plan>> response) {
                    planList.addAll(response.body());
                    for (Plan plan : planList) {
                        plans.add(plan.getPlanName());
                    }

                }

                @Override
                public void onFailure(Call<List<Plan>> call, Throwable t) {

                }
            });

        } catch (Exception e) {

        }
        return plans;
    }
}