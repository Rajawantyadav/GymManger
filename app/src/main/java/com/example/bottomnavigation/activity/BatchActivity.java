package com.example.bottomnavigation.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottomnavigation.R;
import com.example.bottomnavigation.adapters.BatchAdapter;
import com.example.bottomnavigation.listener.SelectListener;
import com.example.bottomnavigation.model.Batch;
import com.example.bottomnavigation.network.ApiAgent;
import com.example.bottomnavigation.response.BatchResp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BatchActivity extends AppCompatActivity {
    List<Batch> dataList = new ArrayList<>();
    RecyclerView recyclerView;
    Button addBatchButton;
    SelectListener listener;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batch);
        recyclerView = findViewById(R.id.recyclerView2);
        addBatchButton = findViewById(R.id.add_batch_button);
        Intent intent = getIntent();
        String ownerId = intent.getStringExtra("ownerId");

        try {
            Call<BatchResp> batchCall = ApiAgent.getAPIInstance().getApi().getBatches(ownerId);
            batchCall.enqueue(new Callback<BatchResp>() {
                @Override
                public void onResponse(Call<BatchResp> call, Response<BatchResp> response) {
                    if (response.body()!=null &&response.body().getBatches() != null)
                        dataList.addAll(response.body().getBatches());
                    listener = new SelectListener() {
                        @Override
                        public void onItemClickListener(Object object) {
                            Batch batch = (Batch) object;
                            Intent intent = new Intent(getApplicationContext(), EditBatchActivity.class);
                            intent.putExtra("batch_id", batch.getBatchId());
                            intent.putExtra("batch_name", batch.getBatchName());
                            intent.putExtra("batch_limit", batch.getLimit());
                            intent.putExtra("batch_start_time", batch.getBatchStartTime());
                            intent.putExtra("batch_end_time", batch.getBatchEndTime());
                            startActivity(intent);
                        }
                    };
                    BatchAdapter adapter = new BatchAdapter(getApplicationContext(), dataList, listener);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(
                            new LinearLayoutManager(BatchActivity.this));
                }

                @Override
                public void onFailure(Call<BatchResp> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Something went wrong...", Toast.LENGTH_SHORT);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        addBatchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getApplicationContext(), AddNewBatchActivity.class);
                myIntent.putExtra("ownerId", ownerId);
                startActivity(myIntent);
            }
        });
    }


}