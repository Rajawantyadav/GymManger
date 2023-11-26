package com.example.bottomnavigation.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.bottomnavigation.R;
import com.example.bottomnavigation.activity.AddNewUserActivity;
import com.example.bottomnavigation.activity.AttendanceActivity;
import com.example.bottomnavigation.activity.BatchActivity;
import com.example.bottomnavigation.activity.EnquiryActivity;
import com.example.bottomnavigation.activity.ExpenseActivity;
import com.example.bottomnavigation.activity.MembersActivity;
import com.example.bottomnavigation.activity.PlansActivity;
import com.example.bottomnavigation.activity.ReportsActivity;
import com.example.bottomnavigation.adapters.GridViewAdapter;

public class HomeFragment extends Fragment {
    GridView gridView;
    String[] dashBoardNames = {"Add", "Plans", "Attendance", "Batch", "Members", "Report", "Enquiry", "Expense", "How to use"};
    int[] dashBoardIcons = {R.drawable.adduser, R.drawable.plans, R.drawable.attendence, R.drawable.batch, R.drawable.members, R.drawable.repots, R.drawable.enquiry, R.drawable.expense, R.drawable.youtube};

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        Bundle bundle = this.getArguments();
        String ownerId = bundle.getString("ownerId");
        // Inflate the layout for this fragment
        gridView = view.findViewById(R.id.gridView);
        GridViewAdapter adapter = new GridViewAdapter(getContext(), dashBoardNames, dashBoardIcons);
        gridView.setAdapter(adapter);
        //Setting On ItemClickListener on grid view
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (dashBoardNames[i].equalsIgnoreCase("Add")) {
                    Intent myIntent = new Intent(getContext(), AddNewUserActivity.class);
                    myIntent.putExtra("ownerId",ownerId);
                    startActivity(myIntent);
                } else if (dashBoardNames[i].equalsIgnoreCase("Plans")) {
                    Intent myIntent = new Intent(getContext(), PlansActivity.class);
                    myIntent.putExtra("ownerId",ownerId);
                    startActivity(myIntent);
                } else if (dashBoardNames[i].equalsIgnoreCase("Attendance")) {
                    Intent myIntent = new Intent(getContext(), AttendanceActivity.class);
                    myIntent.putExtra("ownerId",ownerId);
                    startActivity(myIntent);
                } else if (dashBoardNames[i].equalsIgnoreCase("Batch")) {
                    Intent myIntent = new Intent(getContext(), BatchActivity.class);
                    myIntent.putExtra("ownerId",ownerId);
                    startActivity(myIntent);
                } else if (dashBoardNames[i].equalsIgnoreCase("Members")) {
                    Intent myIntent = new Intent(getContext(), MembersActivity.class);
                    myIntent.putExtra("ownerId",ownerId);
                    startActivity(myIntent);
                } else if (dashBoardNames[i].equalsIgnoreCase("Report")) {
                    Intent myIntent = new Intent(getContext(), ReportsActivity.class);
                    myIntent.putExtra("ownerId",ownerId);
                    startActivity(myIntent);
                } else if (dashBoardNames[i].equalsIgnoreCase("Enquiry")) {
                    Intent myIntent = new Intent(getContext(), EnquiryActivity.class);
                    myIntent.putExtra("ownerId",ownerId);
                    startActivity(myIntent);
                } else if (dashBoardNames[i].equalsIgnoreCase("Expense")) {
                    Intent myIntent = new Intent(getContext(), ExpenseActivity.class);
                    myIntent.putExtra("ownerId",ownerId);
                    startActivity(myIntent);
                } else {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=4DkNCgUXbig&list=RDS980-z1qx3g&index=27&ab_channel=NAVRecords")));
                }


            }
        });
        return view;
    }
}