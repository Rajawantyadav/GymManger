package com.example.bottomnavigation.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottomnavigation.R;
import com.example.bottomnavigation.model.Plan;

import java.util.List;

public class PlanAdapter extends RecyclerView.Adapter<PlanAdapter.ViewHolder> {
    Context context;
    List<Plan> dataList;

    public PlanAdapter(Context context, List<Plan> dataList) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public PlanAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.plan_cardview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanAdapter.ViewHolder holder, int position) {
        Plan plan = dataList.get(position);
        holder.plan_duration.setText(plan.getPlanDuration());
        holder.plan_name.setText(plan.getPlanName());
        holder.plan_price.setText(plan.getPlanPrice());
        holder.plan_description.setText(plan.getPlanDescription());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView plan_name, plan_price, plan_duration, plan_description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            plan_duration = itemView.findViewById(R.id.duration);
            plan_price = itemView.findViewById(R.id.plan_price);
            plan_description = itemView.findViewById(R.id.plan_desc);
            plan_name = itemView.findViewById(R.id.plan_name);

        }
    }
}
