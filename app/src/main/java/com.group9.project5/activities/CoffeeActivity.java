package com.group9.project5.activities;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.group9.project5.R;

public class CoffeeActivity extends AppCompatActivity {

    private Button addToOrderBTN;
    private CheckBox sweetcream, frenchvanilla, irishcream, caramel, mocha;
    private Spinner coffeequantity, cupSize;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coffee_view);

        //populate spinner/combobox
        Integer [] quantityArray = new Integer[]{1,2,3,4};
        Spinner s = (Spinner) findViewById(R.id.coffeequantity);
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this,
                android.R.layout.simple_spinner_item, quantityArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);

        String [] sizeArray = new String[]{"Short","Tall","Grande","Venti" };
        Spinner s2 = (Spinner) findViewById(R.id.cupSize);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, sizeArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter2);


    }

}
