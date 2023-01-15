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

public class ContactGridViewAdapter extends BaseAdapter {
    Context context;
    String[] names;
    int[] icons;

    public ContactGridViewAdapter(Context context, String[] names, int[] icons) {
        this.context = context;
        this.names = names;
        this.icons = icons;
    }

    @Override
    public int getCount() {
        return names.length;
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
        View view1 = inflater.inflate(R.layout.contactlayout, null);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        ImageView img = view1.findViewById(R.id.img1);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        TextView headingTv = view1.findViewById(R.id.tv1);
        img.setImageResource(icons[position]);
        headingTv.setText(names[position]);
        return view1;
    }
}
