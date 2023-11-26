package com.example.bottomnavigation.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.bottomnavigation.R;
import com.example.bottomnavigation.adapters.CountGridViewAdapter;
import com.example.bottomnavigation.adapters.GridViewAdapter;

public class SearchFragment extends Fragment {
    GridView gridView;
    String[] headingNames = {"Total Collection", "Live Members", "Expired Member", "Expired Today", "Expire in (1-5)", "Expire in (6-10)", "Expire in (11-15)", "Unpaid Members", "Birthday today", "Total Expense","Blocked"};
    String[] headingwisecount = {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0","0"};

    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();
        String ownerId = bundle.getString("ownerId");
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        gridView = view.findViewById(R.id.gridView);
        CountGridViewAdapter adapter = new CountGridViewAdapter(getContext(), headingNames, headingwisecount);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getContext(),headingNames[i],Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}