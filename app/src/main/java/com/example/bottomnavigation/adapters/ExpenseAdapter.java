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
import com.example.bottomnavigation.model.EnquiryMember;
import com.example.bottomnavigation.model.GymExpense;

import java.util.List;

public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.ViewHolder> {
    Context context;
    List<GymExpense> dataList;

    public ExpenseAdapter(Context context, List<GymExpense> dataList) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public ExpenseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.enquiry_member_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpenseAdapter.ViewHolder holder, int position) {
        GymExpense gymExpense = dataList.get(position);
        holder.enq_name.setText(gymExpense.getExpense_title());
        holder.enq_date.setText(gymExpense.getExpense_date());
        holder.enq_mobile.setText(gymExpense.getExpense_amount());
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
