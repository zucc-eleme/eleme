package com.example.myapplication.control;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.myapplication.R;
import com.example.myapplication.control.customer.CustomInfo;


public class LoginCustomerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_custoner);

        Toolbar toolbar = findViewById(R.id.login_customer_toolbar);
        toolbar.setTitle("用户登录");
        toolbar.setNavigationIcon(R.drawable.iv_back_select);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button login = findViewById(R.id.login_customer);
        login.setOnClickListener(v->{
            String account=((EditText)findViewById(R.id.editUserId)).getText().toString();
            String pwd=((EditText)findViewById(R.id.editUserPwd)).getText().toString();
            if(account.equals(""))
                Toast.makeText(this,"用户名为空",Toast.LENGTH_SHORT).show();
            else if(pwd.equals(""))
                Toast.makeText(this,"密码为空",Toast.LENGTH_SHORT).show();
            else{
                Intent intent=new Intent(LoginCustomerActivity.this, CustomInfo.class);
                startActivity(intent);
            }

        });

        findViewById(R.id.pwd_forget).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginCustomerActivity.this, ForgetPwdActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.customer_create).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginCustomerActivity.this, CustomerCreateActivity.class);
                startActivity(intent);
            }
        });

    }
}