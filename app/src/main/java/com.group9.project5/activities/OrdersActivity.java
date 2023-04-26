package com.group9.project5.activities;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.group9.project5.R;
import com.group9.project5.model.Order;

import java.util.ArrayList;

public class OrdersActivity extends AppCompatActivity {
    private ListView ordersListView;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orders_view);

        ordersListView = (ListView) findViewById(R.id.ordersListView);
        ArrayList<String> strings = new ArrayList<String>();

        for (Order order : Order.FINALIZED_ORDERS){
            strings.add("Order# " + order.getOrderNumber() + " \t\t$" + order.getTotal());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.item_view,R.id.itemTextView,strings);

        ordersListView.setAdapter(adapter);
    }
}
