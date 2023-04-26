package com.group9.project5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DonutAdapter extends RecyclerView.Adapter<DonutHolder> {
    Context context;
    ArrayList<Donut> donuts;
    public DonutAdapter(Context context, ArrayList<Donut> donuts) {
        this.context = context;
        this.donuts = donuts;
    }


    @NonNull
    @Override
    public DonutHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DonutHolder(LayoutInflater.from(context).inflate(R.layout.donut_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DonutHolder holder, int position) {
        holder.donutView.setText(donuts.get(position).getFlavor());
        holder.imageView.setImageResource(donuts.get(position).getImage());
        holder.priceView.setText(donuts.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return donuts.size();
    }

}
