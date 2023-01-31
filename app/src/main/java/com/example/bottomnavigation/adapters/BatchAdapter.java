package com.example.bottomnavigation.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottomnavigation.R;
import com.example.bottomnavigation.listener.SelectListener;
import com.example.bottomnavigation.model.Batch;
import com.example.bottomnavigation.model.Plan;

import java.util.List;

public class BatchAdapter extends RecyclerView.Adapter<BatchAdapter.ViewHolder> {
    Context context;
    List<Batch> dataList;
    SelectListener listener;

    public BatchAdapter(Context context, List<Batch> dataList, SelectListener listener) {
        this.dataList = dataList;
        this.context = context;
        this.listener = listener;

    }

    @NonNull
    @Override
    public BatchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.batch_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BatchAdapter.ViewHolder holder, int position) {
        Batch batch = dataList.get(position);
        holder.batchName.setText(batch.getBatchName());
        holder.batchStartTime.setText(batch.getBatchStartTime());
        holder.batchEndTime.setText(batch.getBatchEndTime());
        holder.batchLimit.setText(batch.getLimit());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClickListener(batch);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView batchName, batchStartTime, batchEndTime, batchLimit;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            batchName = itemView.findViewById(R.id.batch_name);
            batchStartTime = itemView.findViewById(R.id.batch_start_time);
            batchEndTime = itemView.findViewById(R.id.batch_end_time);
            batchLimit = itemView.findViewById(R.id.batch_limt);
            cardView = itemView.findViewById(R.id.batch_container);

        }
    }
}
