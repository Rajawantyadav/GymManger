package com.example.bottomnavigation.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottomnavigation.R;
import com.example.bottomnavigation.model.Member;

import java.util.List;

public class MemberListAdapter extends RecyclerView.Adapter<MemberListAdapter.ViewHolder> {
    Context context;
    List<Member> dataList;

    public MemberListAdapter(Context context, List<Member> dataList) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public MemberListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.memebers_layaout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MemberListAdapter.ViewHolder holder, int position) {
        Member member = dataList.get(position);
        holder.memberName.setText(member.getMemberName());
        holder.joiningDate.setText(member.getJoiningDate());
        holder.activePlanName.setText(member.getActivePlanName());
        holder.planExpireDate.setText(member.getPlanExpireDate());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView memberName, activePlanName, planExpireDate, joiningDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            memberName = itemView.findViewById(R.id.m_name);
            activePlanName = itemView.findViewById(R.id.active_plan);
            planExpireDate = itemView.findViewById(R.id.plan_expire_date);
            joiningDate = itemView.findViewById(R.id.joining_date);

        }
    }
}
