package com.example.bottomnavigation.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bottomnavigation.R;
import com.example.bottomnavigation.model.GymExpense;
import com.example.bottomnavigation.model.MemberAttendance;
import com.example.bottomnavigation.network.ApiAgent;
import com.example.bottomnavigation.response.MemberAddResp;
import com.example.bottomnavigation.utility.DatePickerDialogFragment;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddNewExpenseActivity extends AppCompatActivity {
    EditText expense_date, expense_title, expense_amount;
    Button expense_add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_expense);
        expense_date = findViewById(R.id.expense_date);
        expense_title = findViewById(R.id.expense_title);
        expense_amount = findViewById(R.id.expense_amount);
        expense_date = findViewById(R.id.expense_date);
        expense_add_button = findViewById(R.id.expense_add_button);
        Intent intent = getIntent();
        String ownerId = intent.getStringExtra("ownerId");

        expense_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.app.DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        expense_date.setText(day + "/" + month + "/" + year);
                    }
                };
                DatePickerDialogFragment datePickerDialogFragment = new DatePickerDialogFragment(listener);
                datePickerDialogFragment.show(getSupportFragmentManager(), "Select Date");
            }
        });

        expense_add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GymExpense gymExpense = new GymExpense();
                gymExpense.setExpense_amount(expense_amount.getText().toString());
                gymExpense.setExpense_date(expense_date.getText().toString());
                gymExpense.setExpense_title(expense_title.getText().toString());
                gymExpense.setOwnerId(ownerId);
                try {
                    Call<MemberAddResp> gymExpenseCall = ApiAgent.getAPIInstance().getApi().addExpense(gymExpense);
                    gymExpenseCall.enqueue(new Callback<MemberAddResp>() {
                        @Override
                        public void onResponse(Call<MemberAddResp> call, Response<MemberAddResp> response) {
                            if (response.body().getError().equalsIgnoreCase("false")) {
                                Toast.makeText(getApplicationContext(), response.body().getMsg(), Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(getApplicationContext(), ExpenseActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(getApplicationContext(), response.body().getMsg(), Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<MemberAddResp> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "Something went wrong ...", Toast.LENGTH_LONG).show();
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}