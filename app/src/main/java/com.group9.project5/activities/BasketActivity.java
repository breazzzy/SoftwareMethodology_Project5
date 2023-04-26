package com.group9.project5.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.group9.project5.R;
import com.group9.project5.model.MenuItem;
import com.group9.project5.model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BasketActivity extends AppCompatActivity {
    private ListView basketListView;
    private TextView txtSubtotal, txtTax, txtTotal;
    private Button placeOrderBTN;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basket_view);

        basketListView = (ListView) findViewById(R.id.basketListView);
        txtSubtotal = (TextView) findViewById(R.id.txtSubTotal);
        txtTax = (TextView) findViewById(R.id.txtTax);
        txtTotal = (TextView) findViewById(R.id.txtTotal);
        placeOrderBTN = (Button) findViewById(R.id.placeOrderBTN);

        Log.d("ListView", basketListView.toString());
        ArrayList<String> strings = new ArrayList<>();
        double subtotal = 0;
        double total = 0;
        double tax = 0;

        for(MenuItem item : Order.getCurrentOrder().getMenuItems()){
            strings.add(item.toString() + "\t\t\t$" + item.itemPrice());
            subtotal += item.itemPrice();
        }
        subtotal = Math.round((subtotal) * 100.0)/100.0;
        tax = Math.round((subtotal * MenuItem.TAX) * 100.0)/100.0;
        total = Math.round((subtotal + tax) * 100.0)/100.0;
        txtTax.append(tax +"");
        txtTotal.append(total +"");
        txtSubtotal.append(subtotal +"");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.item_view,R.id.itemTextView,strings);
        Log.d("ArrayAdapter", arrayAdapter.toString());

        basketListView.setAdapter(arrayAdapter);

        placeOrderBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Order.getCurrentOrder().FinalizeOrder();
            }
        });
    }
}
