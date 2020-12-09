package com.example.myapplication.control;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.myapplication.R;


public class LoginCustomerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_custoner);
        Toolbar toolbar = findViewById(R.id.login_customer_toolbar);
        toolbar.setTitle("用户登录");
        toolbar.setNavigationIcon(R.drawable.iv_back);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button login = findViewById(R.id.login_customer);
        TextView textView1 = (TextView) findViewById(R.id.pwd_forget);
        TextView textView2 = (TextView) findViewById(R.id.customer_create);


        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginCustomerActivity.this, ForgetPwdActivity.class);
                startActivity(intent);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginCustomerActivity.this, CustomerCreateActivity.class);
                startActivity(intent);
            }
        });

    }
}