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
        Log.d("Opened","Donut");

        RecyclerView rcview = findViewById(R.id.donutRCV);
        //setupDonuts();
        ArrayList<Donut> donuts = new ArrayList<>();
        donuts.add(new Donut("Strawberry", R.drawable.strawberryfrosting, "1.79"));

        rcview.setLayoutManager(new LinearLayoutManager(this));
        rcview.setAdapter(new DonutAdapter(getApplicationContext(), donuts));
    }

   /* private void setupDonuts(){
        String [] donutNames = getResources().getStringArray(R.array.flavorNames);
        for (int i=0;i<donutNames.length; i++){
            donuts.add(new Donut(donutNames[i], flavorImages[i], 1.79));
        }
    }*/

}
