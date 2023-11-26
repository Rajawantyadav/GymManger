package com.example.bottomnavigation.activity;

import android.annotation.SuppressLint;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bottomnavigation.R;
import com.example.bottomnavigation.model.Batch;
import com.example.bottomnavigation.network.ApiAgent;
import com.example.bottomnavigation.response.MemberAddResp;
import com.example.bottomnavigation.utility.TimePickerDialogFragment;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddNewBatchActivity extends AppCompatActivity {
    TextView batchName, batchStartTime, batchEndTime, batchLimit;
    Button btnAddBatch;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_batch);
        batchLimit = findViewById(R.id.batch_limt);
        batchName = findViewById(R.id.batch_name);
        batchStartTime = findViewById(R.id.batch_start_time);
        batchEndTime = findViewById(R.id.batch_end_time);
        btnAddBatch = findViewById(R.id.button_addBatch);
        Intent intent = getIntent();
        String ownerId = intent.getStringExtra("ownerId");
        batchStartTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog.OnTimeSetListener listener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        batchStartTime.setText(i + ":" + i1);
                    }
                };
                TimePickerDialogFragment fragment = new TimePickerDialogFragment(listener);
                fragment.show(getSupportFragmentManager(), "Select Time");
            }
        });
        batchEndTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog.OnTimeSetListener listener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        batchEndTime.setText(i + ":" + i1);
                    }
                };
                TimePickerDialogFragment fragment = new TimePickerDialogFragment(listener);
                fragment.show(getSupportFragmentManager(), "Select Time");
            }
        });
        btnAddBatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (batchName.getText().length() == 0 || batchStartTime.getText().length() == 0 || batchEndTime.getText().length() == 0
                        || batchLimit.getText().length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please fill all the required fields..", Toast.LENGTH_SHORT).show();
                } else {
                    Batch batch = new Batch();
                    batch.setBatchName(batchName.getText().toString());
                    batch.setBatchStartTime(batchStartTime.getText().toString());
                    batch.setBatchEndTime(batchEndTime.getText().toString());
                    batch.setLimit(batchLimit.getText().toString());
                    batch.setBatchActive("1");
                    batch.setOwnerId(ownerId);
                    try {
                        Call<MemberAddResp> addBatchCall = ApiAgent.getAPIInstance().getApi().addBatch(batch);
                        addBatchCall.enqueue(new Callback<MemberAddResp>() {
                            @Override
                            public void onResponse(Call<MemberAddResp> call, Response<MemberAddResp> response) {
                                Toast.makeText(getApplicationContext(), response.body().getMsg(), Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), BatchActivity.class);
                                intent.putExtra("ownerId",ownerId);
                                startActivity(intent);
                            }

                            @Override
                            public void onFailure(Call<MemberAddResp> call, Throwable t) {
                                Toast.makeText(getApplicationContext(), "Something went wrong..?", Toast.LENGTH_SHORT).show();
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