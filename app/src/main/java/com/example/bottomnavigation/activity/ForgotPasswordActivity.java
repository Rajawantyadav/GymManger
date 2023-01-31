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

public class ForgotPasswordActivity extends AppCompatActivity {
    Button btn_rest;
    EditText reset_email_mobile;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        btn_rest = findViewById(R.id.btn_rest);
        reset_email_mobile = findViewById(R.id.reset_email_mobile);
        btn_rest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email_mobile = reset_email_mobile.getText().toString();
                if (email_mobile.length() != 0) {
                    Toast.makeText(getApplicationContext(), "Password has been sent to the registered mobile/email..", Toast.LENGTH_LONG).show();
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                } else {
                    reset_email_mobile.setFocusableInTouchMode(true);
                    reset_email_mobile.requestFocus();
                    Toast.makeText(getApplicationContext(), "Email/Mobile can not be blank..", Toast.LENGTH_LONG).show();

                }

            }
        });
    }
}