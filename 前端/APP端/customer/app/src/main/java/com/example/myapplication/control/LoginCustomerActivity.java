package com.example.myapplication.control;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.alibaba.fastjson.JSONObject;
import com.example.myapplication.R;
import com.example.myapplication.bean.User;
import com.example.myapplication.util.Contants;


import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class LoginCustomerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_custoner);

        Toolbar toolbar = findViewById(R.id.login_customer_toolbar);
        toolbar.setTitle("用户登录");
        setSupportActionBar(toolbar);

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

        Button login = findViewById(R.id.login_customer);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginCustomerActivity.this.loginGet();
            }
        });
    }
    private void loginGet() {
        final String account = ((EditText) findViewById(R.id.editUserId)).getText().toString();
        final String pwd = ((EditText) findViewById(R.id.editUserPwd)).getText().toString();

        if (account.equals(""))
            Toast.makeText(this, "用户名为空", Toast.LENGTH_SHORT).show();
        else if (pwd.equals(""))
            Toast.makeText(this, "密码为空", Toast.LENGTH_SHORT).show();
        else {
            new Thread(){
                @Override
                public void run() {
                    try {
                        OkHttpClient client = new OkHttpClient();
                        Request request = new Request.Builder()
                                .get()
                                .url(Contants.SPRING_USER + "userLogin/login/userPhone?userPhone=" + account + "&userPwd=" + pwd)
                                .build();
                        Response response = client.newCall(request).execute();//回调
                        String ok = response.body().string();
                        if (response.isSuccessful()) {
                            Log.d("===============",ok+"&"+account+"&"+pwd);
                        }
                        final String finalOk=ok;
                        getLocalUser(account);;//保存登录用户
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if ("true".equals(finalOk)) {
                                    Toast.makeText(LoginCustomerActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(LoginCustomerActivity.this, CustomerMainActivity.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(LoginCustomerActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }catch (IOException e)
                    { e.printStackTrace(); }
                }
            }.start();
        }
    }

    private void getLocalUser(final String mainPhone){
        new Thread(){
            @Override
            public void run() {
                String localPhone=mainPhone;
                if(localPhone.equals(""))
                    localPhone="123456";
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .get()
                        .url(Contants.SPRING_USER + "userLogin/query/userPhone?userPhone=" + localPhone)
                        .build();
                try {
                    Response response = client.newCall(request).execute();
                    final String localUserJson = response.body().string();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            CustomerMainActivity.localUserObject= JSONObject.parseObject(localUserJson, User.class);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }
}