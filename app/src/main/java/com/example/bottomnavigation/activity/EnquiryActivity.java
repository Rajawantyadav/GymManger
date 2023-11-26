package com.example.bottomnavigation.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.bottomnavigation.R;
import com.example.bottomnavigation.adapters.EnquiryAdapter;
import com.example.bottomnavigation.model.EnquiryMember;
import com.example.bottomnavigation.network.ApiAgent;
import com.example.bottomnavigation.response.EnquiryResp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EnquiryActivity extends AppCompatActivity {

    Button enquiry_new_btn;
    String ownerId;
    RecyclerView recyclerView;
    List<EnquiryMember> enquiryMemberList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enquiry);
        enquiry_new_btn = findViewById(R.id.new_enquiry_btn);
        recyclerView = findViewById(R.id.enquiry_recyclerView);
        Intent intent = getIntent();
        ownerId = intent.getStringExtra("ownerId");
        try {
            Call<EnquiryResp> enquiryMemberCall = ApiAgent.getAPIInstance().getApi().getEnquiryMembers(ownerId);
            enquiryMemberCall.enqueue(new Callback<EnquiryResp>() {
                @Override
                public void onResponse(Call<EnquiryResp> call, Response<EnquiryResp> response) {
                    if(response.isSuccessful()){
                        enquiryMemberList.addAll(response.body().getEnquiryMembers());
                        EnquiryAdapter adapter = new EnquiryAdapter(getApplicationContext(), enquiryMemberList);
                        recyclerView.setAdapter(adapter);
                        recyclerView.setLayoutManager(
                                new LinearLayoutManager(EnquiryActivity.this));
                    }
                }

                @Override
                public void onFailure(Call<EnquiryResp> call, Throwable t) {
                    Toast.makeText(getApplicationContext(),"Something went wrong",Toast.LENGTH_LONG);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        enquiry_new_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddNewEnquiryActivity.class);
                intent.putExtra("ownerId", ownerId);
                startActivity(intent);
            }
        });
    }
}