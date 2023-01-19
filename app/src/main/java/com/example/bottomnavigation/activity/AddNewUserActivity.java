package com.example.bottomnavigation.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bottomnavigation.R;
import com.example.bottomnavigation.fragments.HomeFragment;
import com.example.bottomnavigation.network.ApiAgent;
import com.example.bottomnavigation.request.MemberDetails;
import com.example.bottomnavigation.response.MemberAddResp;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddNewUserActivity extends AppCompatActivity {
    TextView name, email, mobile, dob, weight;
    RadioButton radioMale, radioFemale;
    Spinner batchNameSpinner, planNameSpinner;
    Button addButton;
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


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    String gender = null;
                    if (radioFemale.isChecked()) {
                       gender=radioFemale.getText().toString();

                    } else if (radioMale.isChecked()) {
                        gender=radioMale.getText().toString();
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
}