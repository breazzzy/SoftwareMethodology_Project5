package com.group9.project5;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DonutSelectedActivity extends AppCompatActivity {
    private Button btn_DonutName;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donut_selected);
        btn_DonutName = findViewById(R.id.addbtn);
        Intent intent = getIntent();
        btn_DonutName.setText(intent.getStringExtra("DONUT"));
    }
}
