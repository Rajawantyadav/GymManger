package com.example.bottomnavigation.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottomnavigation.R;
import com.example.bottomnavigation.listener.SelectListener;
import com.example.bottomnavigation.model.Batch;
import com.example.bottomnavigation.model.EnquiryMember;

import java.util.List;

public class EnquiryAdapter extends RecyclerView.Adapter<EnquiryAdapter.ViewHolder> {
    Context context;
    List<EnquiryMember> dataList;

    public EnquiryAdapter(Context context, List<EnquiryMember> dataList) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public EnquiryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.enquiry_member_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EnquiryAdapter.ViewHolder holder, int position) {
        EnquiryMember enquiryMember = dataList.get(position);
        holder.enq_name.setText(enquiryMember.getMember_name());
        holder.enq_date.setText(enquiryMember.getEnquiry_date());
        holder.enq_mobile.setText(enquiryMember.getMember_mobile());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView enq_name, enq_mobile, enq_date;
        CardView enq_card_view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            enq_date = itemView.findViewById(R.id.enq_date);
            enq_mobile = itemView.findViewById(R.id.enq_mobile);
            enq_name = itemView.findViewById(R.id.enq_name);
            enq_card_view = itemView.findViewById(R.id.enq_card_view);

        }
    }
}
