package com.example.bottomnavigation.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.bottomnavigation.R;
import com.example.bottomnavigation.utility.DatePickerDialogFragment;

import java.util.ArrayList;
import java.util.List;

public class ReportsActivity extends AppCompatActivity {
    Spinner report_spinner;
    EditText from_date, to_date;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);
        report_spinner = findViewById(R.id.report_spinner);
        from_date = findViewById(R.id.from_date);
        to_date = findViewById(R.id.to_date);

        from_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.app.DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        from_date.setText(day + "/" + month + "/" + year);
                    }
                };
                DatePickerDialogFragment datePickerDialogFragment = new DatePickerDialogFragment(listener);
                datePickerDialogFragment.show(getSupportFragmentManager(), "Select Date");
            }
        });
        to_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.app.DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        to_date.setText(day + "/" + month + "/" + year);
                    }
                };
                DatePickerDialogFragment datePickerDialogFragment = new DatePickerDialogFragment(listener);
                datePickerDialogFragment.show(getSupportFragmentManager(), "Select Date");
            }
        });

        List<String> reportsList = new ArrayList<>();
        reportsList.add("Select Report Type");
        reportsList.add("Member Report");
        reportsList.add("Collection Report");
        reportsList.add("Expense Report");
        reportsList.add("Enquiry Report");
        reportsList.add("Attendance Report");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, reportsList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        report_spinner.setAdapter(adapter);

    }
}