package com.example.bottomnavigation.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bottomnavigation.R;

public class ExpenseActivity extends AppCompatActivity {
    Button add_new_expense;
    String ownerId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);
        add_new_expense = findViewById(R.id.new_expense_btn);
        Intent intent = getIntent();
        ownerId = intent.getStringExtra("ownerId");
        

        add_new_expense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddNewExpenseActivity.class);
                intent.putExtra("ownerId",ownerId);
                startActivity(intent);
            }
        });
    }
}