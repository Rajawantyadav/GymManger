package com.example.bottomnavigation.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bottomnavigation.R;
import com.example.bottomnavigation.fragments.ContactFragment;
import com.example.bottomnavigation.model.GymOwner;
import com.example.bottomnavigation.network.ApiAgent;
import com.example.bottomnavigation.response.MemberAddResp;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditGymCenterActivity extends AppCompatActivity {
    String ownerId;
    EditText edit_gym_name, edit_gym_email, edit_gym_mobile;
    Button save_gym_button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_gym_center);
        edit_gym_name = findViewById(R.id.edit_gym_name);
        edit_gym_email = findViewById(R.id.edit_gym_email);
        edit_gym_mobile = findViewById(R.id.edit_gym_mobile);
        save_gym_button = findViewById(R.id.save_gym_button);
        ownerId = getIntent().getStringExtra("ownerId");
        try {
            Call<GymOwner> gymOwnerCall = ApiAgent.getAPIInstance().getApi().getGymOwner(ownerId);
            gymOwnerCall.enqueue(new Callback<GymOwner>() {
                @Override
                public void onResponse(Call<GymOwner> call, Response<GymOwner> response) {
                    GymOwner gymOwner = response.body();
                    edit_gym_name.setText(gymOwner.getOwner_name());
                    edit_gym_email.setText(gymOwner.getOwner_email());
                    edit_gym_mobile.setText(gymOwner.getOwner_mobile());
                }

                @Override
                public void onFailure(Call<GymOwner> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_LONG).show();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        save_gym_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    GymOwner gymOwner = new GymOwner();
                    gymOwner.setOwner_id(ownerId);
                    gymOwner.setOwner_mobile(edit_gym_mobile.getText().toString());
                    gymOwner.setOwner_email(edit_gym_email.getText().toString());
                    gymOwner.setOwner_name(edit_gym_name.getText().toString());
                    Call<MemberAddResp> updateGymOwnerCall = ApiAgent.getAPIInstance().getApi().updateGymOwner(gymOwner);
                    updateGymOwnerCall.enqueue(new Callback<MemberAddResp>() {
                        @Override
                        public void onResponse(Call<MemberAddResp> call, Response<MemberAddResp> response) {
                            Toast.makeText(getApplicationContext(), "Gym details has been updated..", Toast.LENGTH_LONG).show();
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