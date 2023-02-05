package com.example.bottomnavigation.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bottomnavigation.MainActivity;
import com.example.bottomnavigation.R;
import com.example.bottomnavigation.network.ApiAgent;
import com.example.bottomnavigation.request.LoginReq;
import com.example.bottomnavigation.response.MemberAddResp;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    Button btn_login, btn_register, btn_forgot_psw;
    EditText login_email, login_psw;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login_email = findViewById(R.id.login_email);
        login_psw = findViewById(R.id.login_psw);
        btn_login = findViewById(R.id.btn_login);
        btn_register = findViewById(R.id.btn_register);
        btn_forgot_psw = findViewById(R.id.btn_forgot_psw);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = login_email.getText().toString();
                String password = login_psw.getText().toString();
                if (email.length() < 1) {
                    Toast.makeText(getApplicationContext(), "Email can not be blank..", Toast.LENGTH_LONG).show();
                    login_email.setFocusableInTouchMode(true);
                    login_email.requestFocus();
                } else if (password.length() < 1) {
                    Toast.makeText(getApplicationContext(), "Password can not be blank..", Toast.LENGTH_LONG).show();
                    login_psw.setFocusableInTouchMode(true);
                    login_psw.requestFocus();
                } else {
                    LoginReq req = new LoginReq();
                    req.setUserEmailId(email);
                    req.setPassword(password);
                    try {
                        Call<MemberAddResp> loginCall = ApiAgent.getAPIInstance().getApi().loginGymOwner(req);
                        loginCall.enqueue(new Callback<MemberAddResp>() {
                            @Override
                            public void onResponse(Call<MemberAddResp> call, Response<MemberAddResp> response) {
                                if ( response!=null && response.isSuccessful() && response.body().getError().equalsIgnoreCase("false")) {
                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(getApplicationContext(), "Incorrect email or password.", Toast.LENGTH_LONG).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<MemberAddResp> call, Throwable t) {
                                Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_LONG).show();

                            }
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }

            }
        });
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });
        btn_forgot_psw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });
    }
}