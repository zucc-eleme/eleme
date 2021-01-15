package com.example.myapplication.control.identify;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.myapplication.R;
import com.example.myapplication.bean.User;
import com.example.myapplication.control.CustomerMainActivity;
import com.example.myapplication.control.LoginCustomerActivity;

public class CustomInfoActivity extends AppCompatActivity implements View.OnClickListener{
    private Button outLogin,changeAdress,changePwd,searchDiscount,changeId;
    private ImageView backButton;
    private TextView olduserName;

    public static User oldUser;
    private String sex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_info);
        oldUser=CustomerMainActivity.localUserObject;

        if(CustomerMainActivity.localUserObject.getUserSex()==0)
            sex="man";
        else
            sex="women";

        if(oldUser==null){ return; }
        olduserName=findViewById(R.id.olduser_name);
        olduserName.setText(CustomerMainActivity.localUserObject.getUserName()+sex+",你好!");

        Toolbar toolbar = findViewById(R.id.toolbar_customer_info);
        setSupportActionBar(toolbar);
        backButton=findViewById(R.id.toolbar_button_customer_info_back);
        outLogin=findViewById(R.id.out_login);
        changeAdress=findViewById(R.id.change_adress);
        changePwd=findViewById(R.id.change_pwd);
        searchDiscount=findViewById(R.id.search_discount);
        changeId=findViewById(R.id.change_id);

        backButton.setOnClickListener(this);
        outLogin.setOnClickListener(this);
        changeAdress.setOnClickListener(this);
        changePwd.setOnClickListener(this);
        searchDiscount.setOnClickListener(this);
        changeId.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.toolbar_button_customer_info_back:
                Intent intent=new Intent(CustomInfoActivity.this,CustomerMainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.out_login:
                Intent intent0=new Intent(CustomInfoActivity.this, LoginCustomerActivity.class);
                startActivity(intent0);
                finish();
                break;
            case R.id.change_adress:
                Intent intent1=new Intent(CustomInfoActivity.this, SearchAddressActivity.class);
                startActivity(intent1);
                break;
            case R.id.change_pwd:
                Intent intent2=new Intent(CustomInfoActivity.this, ChangePwdActivity.class);
                startActivity(intent2);
                break;
            case R.id.search_discount:
                Intent intent3=new Intent(CustomInfoActivity.this, SearchDiscountActivity.class);
                startActivity(intent3);
                break;
            case R.id.change_id:
                final String[] message=new String[]{"昵称："+oldUser.getUserName(),"手机号："+oldUser.getUserPhone(),"身份："+sex,"密码："+oldUser.getUserPwd()};
                AlertDialog alertDialog3 = new AlertDialog.Builder(this)
                        .setTitle("您的个人信息")
                        .setIcon(R.drawable.people)
                        .setItems(message, new DialogInterface.OnClickListener() {//添加列表
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(CustomInfoActivity.this, "点的是：" + message[i], Toast.LENGTH_SHORT).show();
                            }
                        })
                        .create();
                alertDialog3.show();
                break;
        }
    }
}
