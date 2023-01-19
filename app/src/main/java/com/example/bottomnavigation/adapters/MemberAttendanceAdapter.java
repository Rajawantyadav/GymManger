package com.example.bottomnavigation.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottomnavigation.R;
import com.example.bottomnavigation.model.MemberAttendance;

import java.util.List;

public class MemberAttendanceAdapter extends RecyclerView.Adapter<MemberAttendanceAdapter.ViewHolder> {
    Context context;
    List<MemberAttendance> dataList;

    public MemberAttendanceAdapter(Context context, List<MemberAttendance> dataList) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public MemberAttendanceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.member_attendance, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MemberAttendanceAdapter.ViewHolder holder, int position) {
        MemberAttendance memberAttendance = dataList.get(position);
        holder.memberName.setText(memberAttendance.getMemberName());
        holder.punchDate.setText(memberAttendance.getPunchDate());
        holder.punchInTime.setText(memberAttendance.getPunchInTime());
        holder.punchOutTime.setText(memberAttendance.getPunchOutTime());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView memberName, punchInTime, punchOutTime, punchDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            memberName = itemView.findViewById(R.id.memeber_name);
            punchInTime = itemView.findViewById(R.id.punch_in_time);
            punchOutTime = itemView.findViewById(R.id.punch_out_time);
            punchDate = itemView.findViewById(R.id.punch_date);

        }
    }
}
