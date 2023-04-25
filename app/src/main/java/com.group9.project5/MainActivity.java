package com.group9.project5;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

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
        basket = (ImageButton)  findViewById(R.id.IBbasket);
        orders = (ImageButton) findViewById(R.id.IBorders);
    }


    public void openDonutMenu(View view){
        Intent intent = new Intent(this, DonutActivity.class);
        startActivity(intent);
    }
}
