package com.example.bottomnavigation.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bottomnavigation.R;

public class CountGridViewAdapter extends BaseAdapter {
    Context context;
    String[] headingNames;
    String[] headingwisecount;

    public CountGridViewAdapter(Context context, String[] headingNames, String[] headingwisecount) {
        this.context = context;
        this.headingNames = headingNames;
        this.headingwisecount = headingwisecount;
    }

    @Override
    public int getCount() {
        return headingNames.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = inflater.inflate(R.layout.member_layout, null);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        TextView count = view1.findViewById(R.id.count);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        TextView headingTv = view1.findViewById(R.id.heading_tv);
        headingTv.setText(headingNames[position]);
        count.setText(headingwisecount[position]);
        return view1;
    }
}
