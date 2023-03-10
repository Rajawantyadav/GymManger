package com.example.bottomnavigation.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bottomnavigation.R;
import com.example.bottomnavigation.model.GymOwner;
import com.example.bottomnavigation.network.ApiAgent;
import com.example.bottomnavigation.response.MemberAddResp;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    Button btn_alreadyAccount, btn_register;
    EditText regis_email, regis_psw, regis_re_psw, regis_gym_name, regis_mobile;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        regis_email = findViewById(R.id.regis_email);
        regis_psw = findViewById(R.id.regis_psw);
        regis_re_psw = findViewById(R.id.regis_re_pws);
        regis_gym_name = findViewById(R.id.regis_gym_name);
        regis_mobile = findViewById(R.id.regis_mobile);
        btn_alreadyAccount = findViewById(R.id.btn_alreadyAccount);
        btn_register = findViewById(R.id.btn_register);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = regis_email.getText().toString();
                String gym_name = regis_gym_name.getText().toString();
                String password = regis_psw.getText().toString();
                String rePassword = regis_re_psw.getText().toString();
                String mobile = regis_mobile.getText().toString();

                if (gym_name.length() < 1) {
                    Toast.makeText(getApplicationContext(), "Gym center name can not be blank..", Toast.LENGTH_LONG).show();
                    regis_gym_name.setFocusableInTouchMode(true);
                    regis_gym_name.requestFocus();
                } else if (mobile.length() < 1) {
                    Toast.makeText(getApplicationContext(), "Mobile no. can not be blank..", Toast.LENGTH_LONG).show();
                    regis_mobile.setFocusableInTouchMode(true);
                    regis_mobile.requestFocus();
                } else if (email.length() < 1) {
                    Toast.makeText(getApplicationContext(), "Email can not be blank..", Toast.LENGTH_LONG).show();
                    regis_email.setFocusableInTouchMode(true);
                    regis_email.requestFocus();
                } else if (password.length() < 1) {
                    Toast.makeText(getApplicationContext(), "Password can not be blank..", Toast.LENGTH_LONG).show();
                    regis_psw.setFocusableInTouchMode(true);
                    regis_psw.requestFocus();
                } else if (rePassword.length() < 1) {
                    Toast.makeText(getApplicationContext(), "Re-type Password can not be blank..", Toast.LENGTH_LONG).show();
                    regis_re_psw.setFocusableInTouchMode(true);
                    regis_re_psw.requestFocus();
                } else {
                    if (password.equalsIgnoreCase(rePassword)) {
                        GymOwner owner = new GymOwner();
                        owner.setOwner_name(gym_name);
                        owner.setOwner_email(email);
                        owner.setOwner_password(password);
                        owner.setOwner_mobile(mobile);
                        try {
                            Call<MemberAddResp> addGymOwnerCall = ApiAgent.getAPIInstance().getApi().addGymOwner(owner);
                            addGymOwnerCall.enqueue(new Callback<MemberAddResp>() {
                                @Override
                                public void onResponse(Call<MemberAddResp> call, Response<MemberAddResp> response) {
                                    if (response.body().getError().equalsIgnoreCase("false")) {
                                        Toast.makeText(getApplicationContext(), "You have successfully registered..", Toast.LENGTH_LONG).show();
                                        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                        startActivity(intent);
                                    } else {
                                        Toast.makeText(getApplicationContext(), "Something went wrong ..", Toast.LENGTH_LONG).show();

                                    }

                                }

                                @Override
                                public void onFailure(Call<MemberAddResp> call, Throwable t) {
                                    Toast.makeText(getApplicationContext(), "Something went wrong ..", Toast.LENGTH_LONG).show();

                                }
                            });
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Password didn't match..", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
        btn_alreadyAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}