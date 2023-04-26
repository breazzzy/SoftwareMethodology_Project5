package com.group9.project5.model;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
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
import com.group9.project5.activities.DonutSelectedActivity;

import java.util.ArrayList;

public class DonutAdapter extends RecyclerView.Adapter<DonutAdapter.DonutHolder> {
    Context context;
    ArrayList<Donut> donuts;
    public DonutAdapter(Context context, ArrayList<Donut> donuts) {
        this.context = context;
        this.donuts = donuts;
    }


    @NonNull
    @Override
    public DonutHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DonutHolder(LayoutInflater.from(context).inflate(R.layout.donut_card,parent,false));
    }

    @Override
    public void onBindViewHolder(final DonutHolder holder, final int position) {
        holder.imageView.setImageResource(donuts.get(position).getImage());
        holder.priceView.setText(donuts.get(position).getPrice());
        holder.donutView.setText(donuts.get(position).getFlavor());

    }

    @Override
    public int getItemCount() {
        return donuts.size();
    }

    public class DonutHolder extends RecyclerView.ViewHolder{
        protected TextView donutView, priceView;
        protected ImageView imageView;
        protected Button btn_add;
        protected ConstraintLayout parentLayout; //this is the row layout

        public DonutHolder(View itemView) {
            super(itemView);
            donutView = (TextView) itemView.findViewById(R.id.donutFlavor);
            priceView = (TextView) itemView.findViewById(R.id.donutPrice);
            imageView = (ImageView) itemView.findViewById(R.id.donutImage);
            btn_add = itemView.findViewById(R.id.btn_add);
            setAddButtonOnClick(itemView); //register the onClicklistener for the button on each row.

            /* set onClickListener for the row layout,
             clicking on a row will navigate to another Activity*/

            /*parentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(itemView.getContext(), DonutSelectedActivity.class);
                    intent.putExtra("DONUT", donutView.getText());
                    itemView.getContext().startActivity(intent);
                }
            });*/
        }

        /**
         * Set the onClickListener for the button on each row.
         * Clicking on the button will create an AlertDialog with the options of YES/NO.
         * @param itemView
         */
        private void setAddButtonOnClick(@NonNull View itemView) {
            btn_add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(itemView.getContext());
                    alert.setTitle("Add to order");
                    alert.setMessage(donutView.getText().toString());
                    //handle the "YES" click
                    alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(itemView.getContext(),
                                    donutView.getText().toString() + " added.", Toast.LENGTH_LONG).show();
                        }
                        //handle the "NO" click
                    }).setNegativeButton("no", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(itemView.getContext(),
                                    donutView.getText().toString() + " not added.", Toast.LENGTH_LONG).show();
                        }
                    });
                    AlertDialog dialog = alert.create();
                    dialog.show();
                }
            });
        }

    }

}


