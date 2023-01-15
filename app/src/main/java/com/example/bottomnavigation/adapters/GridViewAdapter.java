package com.example.bottomnavigation.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bottomnavigation.R;

public class GridViewAdapter extends BaseAdapter {
    Context context;
    String[] dashBoardNames;
    int[] dashBoardIcons;

    public GridViewAdapter(Context context, String[] dashBoardNames, int[] dashBoardIcons) {
        this.context = context;
        this.dashBoardNames = dashBoardNames;
        this.dashBoardIcons = dashBoardIcons;
    }

    @Override
    public int getCount() {
        return dashBoardNames.length;
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
        View view1 = inflater.inflate(R.layout.dashboard, null);
        ImageView img = view1.findViewById(R.id.dashboard_icon);
        TextView headingTv = view1.findViewById(R.id.heading);
        img.setImageResource(dashBoardIcons[position]);
        headingTv.setText(dashBoardNames[position]);
        return view1;
    }
}
