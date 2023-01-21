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
import com.example.bottomnavigation.model.Batch;
import com.example.bottomnavigation.network.ApiAgent;

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

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batch);
        recyclerView = findViewById(R.id.recyclerView2);
        addBatchButton = findViewById(R.id.add_batch_button);

        try {
            Call<List<Batch>> batchCall = ApiAgent.getAPIInstance().getApi().getBatches();
            batchCall.enqueue(new Callback<List<Batch>>() {
                @Override
                public void onResponse(Call<List<Batch>> call, Response<List<Batch>> response) {
                    dataList.addAll(response.body());
                    BatchAdapter adapter = new BatchAdapter(BatchActivity.this, dataList);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(
                            new LinearLayoutManager(BatchActivity.this));
                }

                @Override
                public void onFailure(Call<List<Batch>> call, Throwable t) {
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
                startActivity(myIntent);
            }
        });
    }
}