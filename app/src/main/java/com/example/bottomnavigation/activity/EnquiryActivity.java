package com.example.bottomnavigation.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bottomnavigation.R;

public class EnquiryActivity extends AppCompatActivity {

    Button enquiry_new_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enquiry);
        enquiry_new_btn = findViewById(R.id.new_enquiry_btn);
        enquiry_new_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddNewEnquiryActivity.class);
                startActivity(intent);
            }
        });
    }
}