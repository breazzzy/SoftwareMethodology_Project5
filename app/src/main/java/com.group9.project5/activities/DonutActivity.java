package com.group9.project5.activities;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.group9.project5.R;
import com.group9.project5.model.DonutAdapter;
import com.group9.project5.model.DonutWrapper;

import java.util.ArrayList;

public class DonutActivity extends AppCompatActivity {

    Spinner donutQuantity;

    /*private int[] flavorImages = {R.drawable.plain, R.drawable.blueberry, R.drawable.boston, R.drawable.chocolate, R.drawable.chocolatefrosting,
            R.drawable.vanillafrosting, R.drawable.strawberryfrosting, R.drawable.glazed, R.drawable.cruller, R.drawable.powedered, R.drawable.jelly, R.drawable.lemon};*/

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donut_view);

        Integer [] quantityArray = new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12};
        donutQuantity = (Spinner) findViewById(R.id.donutquantity);
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this,
                android.R.layout.simple_spinner_item, quantityArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        donutQuantity.setAdapter(adapter);

        RecyclerView recyclerView = findViewById(R.id.donutRCV);

        ArrayList<DonutWrapper> donutWrappers = new ArrayList<DonutWrapper>();
        donutWrappers.add(new DonutWrapper("Yeast Plain", R.drawable.plain, "Yeast Donut"));
        donutWrappers.add(new DonutWrapper("Yeast Blueberry", R.drawable.blueberry, "Yeast Donut"));
        donutWrappers.add(new DonutWrapper("Yeast Boston Creme", R.drawable.boston, "Yeast Donut"));
        donutWrappers.add(new DonutWrapper("Yeast Chocolate", R.drawable.chocolate, "Yeast Donut"));
        donutWrappers.add(new DonutWrapper("Cake Chocolate Icing", R.drawable.chocolatefrosting, "Cake Donut"));
        donutWrappers.add(new DonutWrapper("Cake Vanilla Icing", R.drawable.vanillafrosting, "Cake Donut"));
        donutWrappers.add(new DonutWrapper("Cake Strawberry Icing", R.drawable.strawberryfrosting, "Cake Donut"));
        donutWrappers.add(new DonutWrapper("Cake Glazed", R.drawable.glazed, "Cake Donut"));
        donutWrappers.add(new DonutWrapper("Cake Cruller", R.drawable.cruller, "Cake Donut"));
        donutWrappers.add(new DonutWrapper("Powdered Donut Hole", R.drawable.powederedhole, "Donut Hole"));
        donutWrappers.add(new DonutWrapper("Jelly Donut Hole", R.drawable.jellydonutholes, "Donut Hole"));
        donutWrappers.add(new DonutWrapper("Lemon Donut Hole", R.drawable.lemonhole, "Donut Hole"));

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
