package com.group9.project5.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.group9.project5.R;

public class BasketActivity extends AppCompatActivity {
    private ListView basketListView;
    private Button placeOrderBTN;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basket_view);
    }
}
