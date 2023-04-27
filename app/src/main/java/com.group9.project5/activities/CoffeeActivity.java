package com.group9.project5.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.group9.project5.R;
import com.group9.project5.model.Coffee;
import com.group9.project5.model.Order;

import java.io.Console;
import java.util.ArrayList;

public class CoffeeActivity extends AppCompatActivity {

    private Button addToOrderBTN;
    private CheckBox sweetcream, frenchvanilla, irishcream, caramel, mocha;
    private Spinner coffeequantity, cupSize;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coffee_view);
        Log.d("Opened","Coffee");

        //populate spinner
        Integer [] quantityArray = new Integer[]{1,2,3,4};
        coffeequantity = (Spinner) findViewById(R.id.coffeequantity);
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this,
                android.R.layout.simple_spinner_item, quantityArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        coffeequantity.setAdapter(adapter);

        String [] sizeArray = new String[]{"Short","Tall","Grande","Venti" };
        cupSize = (Spinner) findViewById(R.id.cupSize);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, sizeArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cupSize.setAdapter(adapter2);

        //addons
        sweetcream = (CheckBox) findViewById(R.id.sweetcream);
        irishcream = (CheckBox) findViewById(R.id.irishcream);
        frenchvanilla = (CheckBox) findViewById(R.id.frenchvanilla);
        caramel = (CheckBox) findViewById(R.id.caramel);
        mocha = (CheckBox) findViewById(R.id.mocha);

        addToOrderBTN = (Button) findViewById(R.id.addToOrderBTN);
        addToOrderBTN.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                ArrayList<String> addons = new ArrayList<String>();
                if(sweetcream.isChecked()){
                    addons.add("Sweet Cream");
                }
                if(irishcream.isChecked()){
                    addons.add("Irish Cream");
                }
                if(frenchvanilla.isChecked()){
                    addons.add("French Vanilla");
                }
                if(caramel.isChecked()){
                    addons.add("Caramel");
                }
                if(mocha.isChecked()){
                    addons.add("Mocha");
                }
                Coffee coffee = new Coffee(
                        cupSize.getSelectedItem().toString(),
                        addons,
                        Integer.parseInt(coffeequantity.getSelectedItem().toString())
                );
                Order.getCurrentOrder().add(coffee);
            }
        });
    }

}
