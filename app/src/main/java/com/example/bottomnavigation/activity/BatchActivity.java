package com.example.bottomnavigation.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottomnavigation.AddNewBatchActivity;
import com.example.bottomnavigation.AddNewPlanActivity;
import com.example.bottomnavigation.R;
import com.example.bottomnavigation.adapters.BatchAdapter;
import com.example.bottomnavigation.model.Batch;

import java.util.ArrayList;
import java.util.List;

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
        addBatchButton=findViewById(R.id.add_batch_button);
        dataList.add(new Batch("new batch", "12 PM", "1:30 PM", "22"));
        dataList.add(new Batch("new batch", "12 PM", "1:30 PM", "22"));
        dataList.add(new Batch("new batch", "12 PM", "1:30 PM", "22"));
        dataList.add(new Batch("new batch", "12 PM", "1:30 PM", "22"));
        BatchAdapter adapter = new BatchAdapter(BatchActivity.this, dataList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(BatchActivity.this));
        addBatchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getApplicationContext(), AddNewBatchActivity.class);
                startActivity(myIntent);
            }
        });
    }
}