package com.example.bottomnavigation.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.bottomnavigation.R;
import com.example.bottomnavigation.model.EnquiryMember;
import com.example.bottomnavigation.network.ApiAgent;
import com.example.bottomnavigation.response.MemberAddResp;
import com.example.bottomnavigation.utility.DatePickerDialogFragment;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddNewEnquiryActivity extends AppCompatActivity {

    EditText enquiry_date, enquiry_name, enquiry_email, enquiry_mobile, enquiry_desc;
    Button enquiry_add_button;
    RadioButton enquiry_add_radio_male, enquiry_add_radio_female;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_enquiry);
        enquiry_date = findViewById(R.id.enquiry_date);
        enquiry_name = findViewById(R.id.enquiry_name);
        enquiry_email = findViewById(R.id.enquiry_email);
        enquiry_mobile = findViewById(R.id.enquiry_mobile);
        enquiry_desc = findViewById(R.id.enquiry_desc);
        enquiry_add_radio_male = findViewById(R.id.enquiry_add_radio_male);
        enquiry_add_radio_female = findViewById(R.id.enquiry_add_radio_female);
        enquiry_add_button = findViewById(R.id.enquiry_add_button);
        enquiry_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.app.DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        enquiry_date.setText(day + "/" + month + "/" + year);
                    }
                };
                DatePickerDialogFragment datePickerDialogFragment = new DatePickerDialogFragment(listener);
                datePickerDialogFragment.show(getSupportFragmentManager(), "Select Date");
            }
        });

        enquiry_add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String gender = enquiry_add_radio_male.isChecked() ? "Male" : "Female";
                EnquiryMember enquiryMember = new EnquiryMember();
                enquiryMember.setEnquiry_date(enquiry_date.getText().toString());
                enquiryMember.setEnquiry_desc(enquiry_desc.getText().toString());
                enquiryMember.setMember_email(enquiry_email.getText().toString());
                enquiryMember.setMember_mobile(enquiry_mobile.getText().toString());
                enquiryMember.setMember_name(enquiry_name.getText().toString());
                enquiryMember.setMember_gender(gender);
                try {
                    Call<MemberAddResp> enquiryMemberCall = ApiAgent.getAPIInstance().getApi().addEnquiryMember(enquiryMember);
                    enquiryMemberCall.enqueue(new Callback<MemberAddResp>() {
                        @Override
                        public void onResponse(Call<MemberAddResp> call, Response<MemberAddResp> response) {
                            if (response.body().getError().equalsIgnoreCase("false")) {
                                Toast.makeText(getApplicationContext(), "New Enquiry member added successfully..", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(getApplicationContext(), EnquiryActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(getApplicationContext(), response.body().getMsg(), Toast.LENGTH_LONG).show();

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
        });
    }
}