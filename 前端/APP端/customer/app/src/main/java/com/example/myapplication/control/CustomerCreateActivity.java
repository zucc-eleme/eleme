package com.example.myapplication.control;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.example.myapplication.R;
import com.example.myapplication.util.Contants;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static okhttp3.RequestBody.create;

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
                finish();
            }
        });

        Button register = findViewById(R.id.bt_customer_create);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomerCreateActivity.this.registerBody();
            }
        });
    }

    private void registerBody(){
        new Thread(){
            @Override
            public void run() {
                try{
                    final int id=getMaxUserId();
                    final String name = ((EditText) findViewById(R.id.editText_customer_id_create)).getText().toString();
                    final int sex = backSex();
                    final String phone = ((EditText) findViewById(R.id.editText_customer_phone_create)).getText().toString();
                    final int adress = backAdress();
                    final String mainAdress = ((EditText) findViewById(R.id.editText_customer_adress_create)).getText().toString();
                    final String pwd = ((EditText) findViewById(R.id.editText_customer_pwd_create)).getText().toString();

                    if(name=="")
                        Toast.makeText(CustomerCreateActivity.this, "用户名为空", Toast.LENGTH_SHORT).show();
                    else if(phone.equals(""))
                        Toast.makeText(CustomerCreateActivity.this, "手机号为空", Toast.LENGTH_SHORT).show();
                    else if(pwd.equals(""))
                        Toast.makeText(CustomerCreateActivity.this, "密码为空", Toast.LENGTH_SHORT).show();
                    else {
                        JSONObject body = new JSONObject();
                        body.put("userId", id);
                        body.put("userName", name);
                        body.put("userPhone", phone);
                        body.put("userPwd", pwd);
                        body.put("userAddressId", adress);
                        body.put("userMainAddress", mainAdress);
                        body.put("userSex", sex);
                        OkHttpClient client = new OkHttpClient();
                        Request request = new Request.Builder()
                                .url(Contants.SPRING_USER + "userLogin/register") //后端请求接口的路径
                                .post(RequestBody.create(MediaType.parse("application/json"), body.toJSONString())) //发送JSON格式的body
                                .build(); //创造http请求
                        Response response = client.newCall(request).execute(); //执行发送指令
                        final boolean success = "true".equals(response.body().string());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (success) {
                                    Toast.makeText(CustomerCreateActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(CustomerCreateActivity.this, LoginCustomerActivity.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(CustomerCreateActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }

    private int backSex(){
        RadioGroup sex=(RadioGroup)findViewById(R.id.sex);
        int count = sex.getChildCount();
        for(int i = 0 ;i < count;i++){
            RadioButton rb = (RadioButton)sex.getChildAt(i);
            if(rb.isChecked())
                {count=i;break;}
        }
        return count;
    }

    private int backAdress(){
        RadioGroup sex=(RadioGroup)findViewById(R.id.group_customer_adreess_class);
        int count = sex.getChildCount();
        for(int i = 0 ;i < count;i++){
            RadioButton rb = (RadioButton)sex.getChildAt(i);
            if(rb.isChecked())
            {count=i;break;}
        }
        return count;
    }

    private int getMaxUserId(){
        int ID=0;
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(Contants.SPRING_USER + "userLogin/get/maxUserId") //后端请求接口的路径
                    .get() //发送JSON格式的body
                    .build(); //创造http请求
            Response response = client.newCall(request).execute();
            ID=Integer.parseInt(response.body().string());

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            return ID;
        }
    }

}
