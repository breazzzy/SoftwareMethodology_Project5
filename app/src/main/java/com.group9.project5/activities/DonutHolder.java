package com.group9.project5.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.group9.project5.R;

public class DonutHolder extends RecyclerView.ViewHolder{
        protected TextView donutView, priceView;
        protected ImageView imageView;
        protected Button btn_add;
        protected ConstraintLayout parentLayout; //this is the row layout

        public DonutHolder(@NonNull View itemView) {
            super(itemView);
            donutView = itemView.findViewById(R.id.flavor);
            priceView = itemView.findViewById(R.id.price);
            imageView = itemView.findViewById(R.id.imageView);
            /*btn_add = itemView.findViewById(R.id.btn_add);
            setAddButtonOnClick(itemView); //register the onClicklistener for the button on each row.

            /* set onClickListener for the row layout,
             clicking on a row will navigate to another Activity

            parentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(itemView.getContext(), DonutSelectedActivity.class);
                    intent.putExtra("DONUT", donutname.getText());
                    itemView.getContext().startActivity(intent);
                }
            });*/
        }

        /**
         * Set the onClickListener for the button on each row.
         * Clicking on the button will create an AlertDialog with the options of YES/NO.
         * @param itemView
         */
      /*  private void setAddButtonOnClick(@NonNull View itemView) {
            btn_add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(itemView.getContext());
                    alert.setTitle("Add to order");
                    alert.setMessage(donutname.getText().toString());
                    //handle the "YES" click
                    alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(itemView.getContext(),
                                    donutname.getText().toString() + " added.", Toast.LENGTH_LONG).show();
                        }
                        //handle the "NO" click
                    }).setNegativeButton("no", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(itemView.getContext(),
                                    donutname.getText().toString() + " not added.", Toast.LENGTH_LONG).show();
                        }
                    });
                    AlertDialog dialog = alert.create();
                    dialog.show();
                }
            });
        }*/

}
