package com.group9.project5.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.group9.project5.R;
import com.group9.project5.model.DonutAdapter;
import com.group9.project5.model.DonutWrapper;

import java.util.ArrayList;

public class DonutActivity extends AppCompatActivity {



    /*private int[] flavorImages = {R.drawable.plain, R.drawable.blueberry, R.drawable.boston, R.drawable.chocolate, R.drawable.chocolatefrosting,
            R.drawable.vanillafrosting, R.drawable.strawberryfrosting, R.drawable.glazed, R.drawable.cruller, R.drawable.powedered, R.drawable.jelly, R.drawable.lemon};*/

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donut_view);

        RecyclerView recyclerView = findViewById(R.id.donutRCV);

        ArrayList<DonutWrapper> donutWrappers = new ArrayList<DonutWrapper>();
        donutWrappers.add(new DonutWrapper("Plain", R.drawable.plain, "1.79"));
        donutWrappers.add(new DonutWrapper("Blueberry", R.drawable.blueberry, "1.79"));
        donutWrappers.add(new DonutWrapper("Boston Creme", R.drawable.boston, "1.79"));
        donutWrappers.add(new DonutWrapper("Chocolate", R.drawable.chocolate, "1.79"));
        donutWrappers.add(new DonutWrapper("Chocolate Icing", R.drawable.chocolatefrosting, "1.79"));
        donutWrappers.add(new DonutWrapper("Vanilla Icing", R.drawable.vanillafrosting, "1.79"));
        donutWrappers.add(new DonutWrapper("Strawberry Icing", R.drawable.strawberryfrosting, "1.79"));
        donutWrappers.add(new DonutWrapper("Glazed", R.drawable.glazed, "1.79"));
        donutWrappers.add(new DonutWrapper("Cruller", R.drawable.cruller, "1.79"));
        donutWrappers.add(new DonutWrapper("Powdered", R.drawable.powedered, "1.79"));
        donutWrappers.add(new DonutWrapper("Jelly", R.drawable.jelly, "1.79"));
        donutWrappers.add(new DonutWrapper("Lemon", R.drawable.lemon, "1.79"));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new DonutAdapter(this, donutWrappers));
    }

   /* private void setupDonuts(){
        String [] donutNames = getResources().getStringArray(R.array.flavorNames);
        for (int i=0;i<donutNames.length; i++){
            donuts.add(new Donut(donutNames[i], flavorImages[i], 1.79));
        }
    }*/

}
