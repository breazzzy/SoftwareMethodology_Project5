package com.group9.project5.activities;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.group9.project5.model.Donut;
import com.group9.project5.R;

import java.util.ArrayList;
import java.util.List;

public class DonutActivity extends AppCompatActivity {



    /*private int[] flavorImages = {R.drawable.plain, R.drawable.blueberry, R.drawable.boston, R.drawable.chocolate, R.drawable.chocolatefrosting,
            R.drawable.vanillafrosting, R.drawable.strawberryfrosting, R.drawable.glazed, R.drawable.cruller, R.drawable.powedered, R.drawable.jelly, R.drawable.lemon};*/

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donut_view);

        RecyclerView recyclerView = findViewById(R.id.donutRCV);

        ArrayList<Donut> donuts = new ArrayList<Donut>();
        donuts.add(new Donut("Plain", R.drawable.plain, "1.79"));
        donuts.add(new Donut("Blueberry", R.drawable.blueberry, "1.79"));
        donuts.add(new Donut("Boston Creme", R.drawable.boston, "1.79"));
        donuts.add(new Donut("Chocolate", R.drawable.chocolate, "1.79"));
        donuts.add(new Donut("Chocolate Icing", R.drawable.chocolatefrosting, "1.79"));
        donuts.add(new Donut("Vanilla Icing", R.drawable.vanillafrosting, "1.79"));
        donuts.add(new Donut("Strawberry Icing", R.drawable.strawberryfrosting, "1.79"));
        donuts.add(new Donut("Glazed", R.drawable.glazed, "1.79"));
        donuts.add(new Donut("Cruller", R.drawable.cruller, "1.79"));
        donuts.add(new Donut("Powdered", R.drawable.powedered, "1.79"));
        donuts.add(new Donut("Jelly", R.drawable.jelly, "1.79"));
        donuts.add(new Donut("Lemon", R.drawable.lemon, "1.79"));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new DonutAdapter(getApplicationContext(), donuts));
    }

   /* private void setupDonuts(){
        String [] donutNames = getResources().getStringArray(R.array.flavorNames);
        for (int i=0;i<donutNames.length; i++){
            donuts.add(new Donut(donutNames[i], flavorImages[i], 1.79));
        }
    }*/

}
