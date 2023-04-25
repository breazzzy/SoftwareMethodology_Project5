package com.group9.project5.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.group9.project5.R;

public class MainActivity extends AppCompatActivity {

   private ImageButton donut, coffee, basket, orders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_view);

       donut = (ImageButton) findViewById(R.id.IBdonut);
        donut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDonutMenu(v);
            }
        });
        coffee = (ImageButton) findViewById(R.id.IBcoffee);
        donut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCoffeeMenu(v);
            }
        });
        basket = (ImageButton)  findViewById(R.id.IBbasket);
        basket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBasket(v);
            }
        });
        orders = (ImageButton) findViewById(R.id.IBorders);
        orders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOrders(v);
            }
        });
    }


     public void openDonutMenu(View view){
        Intent intent = new Intent(this, DonutActivity.class);
        startActivity(intent);
    }

    public void openCoffeeMenu(View view){
        Intent intent = new Intent(this, CoffeeActivity.class);
        startActivity(intent);
    }

    public void openBasket(View view){
        Intent intent = new Intent(this, BasketActivity.class);
        startActivity(intent);
    }

    public void openOrders(View view){
        Intent intent = new Intent(this, OrdersActivity.class);
        startActivity(intent);
    }
}
