package com.example.unconsumedfoodmanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<Information> arrayList;

    public MyAdapter(Context context, ArrayList<Information> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        Information info=arrayList.get(position);

        holder.donerName.setText(info.getDonerName());
        holder.donerMob.setText(info.getDonerMob());
        holder.donerAdd.setText(info.getDonerAdd());
        holder.donerPincode.setText(info.getDonerPincode());
        holder.donerMeal.setText(info.getDonerMeal());
        holder.donerHour.setText(info.getDonerHour());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView donerName,donerMob,donerAdd,donerPincode,donerMeal,donerHour;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            donerName=itemView.findViewById(R.id.name);
            donerMob=itemView.findViewById(R.id.mob);
            donerAdd=itemView.findViewById(R.id.add);
            donerPincode=itemView.findViewById(R.id.pincode);
            donerMeal=itemView.findViewById(R.id.meal);
            donerHour=itemView.findViewById(R.id.hour);
        }
    }
}
