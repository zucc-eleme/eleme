package com.example.myapplication.control;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;

public class ShopCreateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shoping_create);
        Toolbar toolbar = findViewById(R.id.shop_create_toolbar);
        toolbar.setTitle("商家注册");
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(ShopCreateActivity.this, LoginCustomerActivity.class);
//                startActivity(intent);
                finish();
            }
        });
    }

}

