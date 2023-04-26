package com.group9.project5.activities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.group9.project5.R;
import com.group9.project5.model.Donut;

import java.util.ArrayList;

public class DonutAdapter  extends RecyclerView.Adapter<DonutHolder> {
    private Context context; //need the context to inflate the layout
    private ArrayList<Donut> donuts; //need the data binding to each row of RecyclerView

    public DonutAdapter(Context context, ArrayList<Donut> donuts) {
        this.context = context;
        this.donuts = donuts;
    }

    /**
     * This method will inflate the row layout for the items in the RecyclerView
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public DonutHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DonutHolder(LayoutInflater.from(context).inflate(R.layout.donut_view,parent,false));
    }

    /**
     * Assign data values for each row according to their "position" (index) when the item becomes
     * visible on the screen.
     * @param holder the instance of ItemsHolder
     * @param position the index of the item in the list of items
     */
    @Override
    public void onBindViewHolder(@NonNull DonutHolder holder, int position) {
        //assign values for each row
        holder.donutname.setText(donuts.get(position).getFlavor());
        holder.donutprice.setText(donuts.get(position).getPrice());
        holder.im_item.setImageResource(donuts.get(position).getImage());
    }

    /**
     * Get the number of items in the ArrayList.
     * @return the number of items in the list.
     */
    @Override
    public int getItemCount() {
        return donuts.size(); //number of MenuItem in the array list.
    }

}
