package com.example.myapplication.control.identify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.myapplication.R;
import com.example.myapplication.control.ForgetPwdActivity;
import com.example.myapplication.util.Contants;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ChangePwdActivity extends AppCompatActivity implements View.OnClickListener{
    Button changPwd;
    private ImageView backButton;
    TextView findPwd;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_pwd);
        Toolbar toolbar = findViewById(R.id.customer_forget_toolbar);
        setSupportActionBar(toolbar);

        backButton=(ImageView)findViewById(R.id.toolbar_button_change_pwd_back);
        findPwd=(TextView) findViewById(R.id.pwd_forget);
        changPwd=(Button)findViewById(R.id.find_back_detail_pwd);

        backButton.setOnClickListener(this);
        changPwd.setOnClickListener(this);
        findPwd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.toolbar_button_change_pwd_back:
                finish();
                break;
            case R.id.find_back_detail_pwd:
                change();
                break;
            case R.id.pwd_forget:
                Intent intent=new Intent(ChangePwdActivity.this, ForgetPwdActivity.class);
                startActivity(intent);
        }
    }
    private void change() {
            new Thread(){
                @Override
                public void run() {
                    try {
                        String phone=((EditText)findViewById(R.id.edit_old_userId)).getText().toString();
                        String oldPwd=((EditText)findViewById(R.id.edit_old_user_pwd)).getText().toString();
                        final String newPwd=((EditText)findViewById(R.id.edit_old_user_new_pwd)).getText().toString();
                        String newPwdTwo=((EditText)findViewById(R.id.edit_user_old_new_two_pwd)).getText().toString();
                        FormBody.Builder params = new FormBody.Builder();
                        params.add("userPhone",phone);
                        params.add("oldPwd",oldPwd);
                        params.add("userPwd1",newPwd);
                        params.add("userPwd2",newPwdTwo);
                        OkHttpClient client = new OkHttpClient();
                        Request request = new Request.Builder()
                                .url(Contants.SPRING_USER + "user/infor/change/userPwd") //后端请求接口的路径
                                .post(params.build()) //发送JSON格式的body
                                .build(); //创造http请求
                        Response response = client.newCall(request).execute(); //执行发送指令
                        final String responseMessage = response.body().string();;
                        final boolean success="修改密码成功！".equals(responseMessage);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if(success){
                                    Toast.makeText(ChangePwdActivity.this, "修改成功，新密码为"+newPwd, Toast.LENGTH_SHORT).show();
                                    finish();
                                }
                                else{
                                    Toast.makeText(ChangePwdActivity.this,responseMessage, Toast.LENGTH_SHORT).show();
                                }

                            }
                        });

                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }.start();

    }
}
