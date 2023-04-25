package com.group9.project5.model;

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
import com.group9.project5.activities.DonutSelectedActivity;

import java.util.ArrayList;

public class DonutAdapter  extends RecyclerView.Adapter<DonutAdapter.DonutHolder> {
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
        //inflate the row layout for the items
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.donut_view, parent, false);

        return new DonutHolder(view);
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
        holder.tv_name.setText(donuts.get(position).getFlavor());
        holder.tv_price.setText((int) donuts.get(position).getUnitPrice());
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

    /**
     * Get the views from the row layout file, similar to the onCreate() method.
     */
    public static class DonutHolder extends RecyclerView.ViewHolder {
        private TextView tv_name, tv_price;
        private ImageView im_item;
        private Button btn_add;
        private ConstraintLayout parentLayout; //this is the row layout

        public DonutHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_flavor);
            tv_price = itemView.findViewById(R.id.tv_price);
            im_item = itemView.findViewById(R.id.im_item);
            btn_add = itemView.findViewById(R.id.btn_add);
            parentLayout = itemView.findViewById(R.id.rowLayout);
            setAddButtonOnClick(itemView); //register the onClicklistener for the button on each row.

            /* set onClickListener for the row layout,
             * clicking on a row will navigate to another Activity
             */
            parentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(itemView.getContext(), DonutSelectedActivity.class);
                    intent.putExtra("ITEM", tv_name.getText());
                    itemView.getContext().startActivity(intent);
                }
            });
            /* Alternatively, use a lamda expression to set the onClickListener for the row layout
            parentLayout.setOnClickListener(view -> {
                    Intent intent = new Intent(itemView.getContext(), ItemSelectedActivity.class);
                    intent.putExtra("ITEM", tv_name.getText());
                    itemView.getContext().startActivity(intent);
                }); */
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
                    alert.setMessage(tv_name.getText().toString());
                    //handle the "YES" click
                    alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(itemView.getContext(),
                                    tv_name.getText().toString() + " added.", Toast.LENGTH_LONG).show();
                        }
                        //handle the "NO" click
                    }).setNegativeButton("no", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(itemView.getContext(),
                                    tv_name.getText().toString() + " not added.", Toast.LENGTH_LONG).show();
                        }
                    });
                    AlertDialog dialog = alert.create();
                    dialog.show();
                }
            });
        }
    }
}
