package com.group9.project5;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DonutActivity extends AppCompatActivity {

    private ArrayList<Donut> donuts = new ArrayList<>();

    private int[] flavorImages = {R.drawable.plain, R.drawable.blueberry, R.drawable.boston, R.drawable.chocolate, R.drawable.chocolatefrosting,
            R.drawable.vanillafrosting, R.drawable.strawberryfrosting, R.drawable.glazed, R.drawable.cruller, R.drawable.powedered, R.drawable.jelly, R.drawable.lemon};

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donut_view);
        RecyclerView rcview = findViewById(R.id.donutView);
        setupDonuts();
        DonutAdapter adapter = new DonutAdapter(this, donuts);
        rcview.setAdapter(adapter);
        rcview.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setupDonuts(){
        String [] donutNames = getResources().getStringArray(R.array.donutNames);
        for (int i=0;i<donutNames.length; i++){
            donuts.add(new Donut(donutNames[i], flavorImages[i], 1.39));
        }
    }

}
