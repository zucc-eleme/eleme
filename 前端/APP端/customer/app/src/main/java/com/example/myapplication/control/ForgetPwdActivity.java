package com.example.myapplication.control;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.example.myapplication.R;
import com.example.myapplication.bean.User;
import com.example.myapplication.util.Contants;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ForgetPwdActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_pwd);
        Toolbar toolbar = findViewById(R.id.pwd_forget_toolbar);
        toolbar.setTitle("找回密码");
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button backPwd=(Button) findViewById(R.id.back_pwd);
        backPwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread() {
                    @Override
                    public void run() {
                        String forgetPwdBackJson = null;
                        try {
                            String phone = ((EditText) findViewById(R.id.pwd_for_back)).getText().toString();

                            OkHttpClient client = new OkHttpClient();
                            Request request = new Request.Builder()
                                    .get()
                                    .url(Contants.SPRING_USER + "userLogin/query/userPhone?userPhone=" + phone)
                                    .build();
                            Response response = client.newCall(request).execute();
                            forgetPwdBackJson = response.body().string();
                            final User forgetPwdUser = JSONObject.parseObject(forgetPwdBackJson, User.class);

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    ((TextView) findViewById(R.id.phone_for_back)).setText(forgetPwdUser.getUserPwd());
                                }
                            });
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
            }
        });
    }
}

