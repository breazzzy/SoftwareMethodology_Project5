package com.group9.project5;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.group9.project5.R;

public class DonutSelectedActivity extends AppCompatActivity {
    private Button btn_DonutName;
    private Spinner donutquantity;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donut_selected);
        btn_DonutName = findViewById(R.id.addbtn);
        Intent intent = getIntent();

        //populate spinner/combobox
        Integer [] quantityArray = new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12};
        Spinner s = (Spinner) findViewById(R.id.donutquantity);
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this,
                android.R.layout.simple_spinner_item, quantityArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
    }
}
