package com.example.myapplication.control;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;

public class CustomerCreateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_create);
        Toolbar toolbar = findViewById(R.id.customer_create_toolbar);
        toolbar.setTitle("用户注册");
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(CustomerCreateActivity.this, LoginCustomerActivity.class);
//                startActivity(intent);
                finish();
            }
        });
    }

}
