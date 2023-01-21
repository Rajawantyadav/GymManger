package com.example.bottomnavigation.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bottomnavigation.R;
import com.example.bottomnavigation.activity.BatchActivity;
import com.example.bottomnavigation.model.Batch;
import com.example.bottomnavigation.network.ApiAgent;
import com.example.bottomnavigation.response.MemberAddResp;

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

        btnAddBatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Batch batch = new Batch();
                batch.setBatchName(batchName.getText().toString());
                batch.setBatchStartTime(batchStartTime.getText().toString());
                batch.setBatchEndTime(batchEndTime.getText().toString());
                batch.setLimit(batchLimit.getText().toString());
                batch.setBatchActive("1");

                try {
                    Call<MemberAddResp> addBatchCall = ApiAgent.getAPIInstance().getApi().addBatch(batch);
                    addBatchCall.enqueue(new Callback<MemberAddResp>() {
                        @Override
                        public void onResponse(Call<MemberAddResp> call, Response<MemberAddResp> response) {
                            Toast.makeText(getApplicationContext(), response.body().getMsg(), Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), BatchActivity.class);
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
        });


    }
}