package com.example.bottomnavigation.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.bottomnavigation.R;
import com.example.bottomnavigation.adapters.ContactGridViewAdapter;


public class ContactFragment extends Fragment {

    String[] names = {"Gym Profile", "Setting", "How to use", "Plan & subscription", "Contact us", "Rate us", "Share this App", "Log out", "Report bugs"};
    int[] icons = {R.drawable.manage_accounts, R.drawable.settings_icon, R.drawable.youtube, R.drawable.subscriptions, R.drawable.contact_support, R.drawable.star_rate_icon, R.drawable.share_icon, R.drawable.logout_icon, R.drawable.bug_icon};
    GridView gridView;

    public ContactFragment() {
        // Required empty public constructor
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        gridView = view.findViewById(R.id.gridView);
        ContactGridViewAdapter adapter = new ContactGridViewAdapter(getContext(), names, icons);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getContext(), names[i], Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}