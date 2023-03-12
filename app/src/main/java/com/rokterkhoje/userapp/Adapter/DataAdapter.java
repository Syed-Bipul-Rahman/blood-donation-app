package com.rokterkhoje.userapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rokterkhoje.userapp.Models.DataModel;
import com.rokterkhoje.userapp.R;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    Context context;
    List<DataModel> dataModels;

    public DataAdapter(Context context, List<DataModel> dataModels) {
        this.context = context;
        this.dataModels = dataModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.status_loyout, null);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.blood_group.setText(dataModels.get(position).getBlood_group());
        holder.hospital_location.setText(dataModels.get(position).getHospital_area());
        holder.location.setText(dataModels.get(position).getLocation());
        holder.details.setText(dataModels.get(position).getDetails());
        holder.status_time.setText(dataModels.get(position).getStatus_time());
        holder.phone.setText(dataModels.get(position).getPhone());
    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView blood_group, hospital_location, location, details, status_time, phone;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

//initializing all data items from view items
            blood_group = itemView.findViewById(R.id.blood_group);
            hospital_location = itemView.findViewById(R.id.hospital_location);
            location = itemView.findViewById(R.id.location);
            details = itemView.findViewById(R.id.details);
            status_time = itemView.findViewById(R.id.status_time);
            phone = itemView.findViewById(R.id.phone);


        }
    }

}
