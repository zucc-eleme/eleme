package com.example.myapplication.control;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class SelectActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select);

        Button select1=(Button)findViewById(R.id.in_customer);
        Button select2=(Button)findViewById(R.id.in_shop);

        select1.setOnClickListener(
                v ->{
                    Intent intent = new Intent(SelectActivity.this, LoginCustomerActivity.class);
                    startActivity(intent);
        });
        select2.setOnClickListener(
                v ->{
                    Intent intent = new Intent(SelectActivity.this, LoginShopActivity.class);
                    startActivity(intent);
                });

    }
}
