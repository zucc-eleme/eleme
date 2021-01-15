package com.example.myapplication.control.identify;

import android.content.DialogInterface;
import android.os.Bundle;

import com.example.myapplication.adapter.InCustomer.AddressAdapter;
import com.example.myapplication.bean.Address;
import com.example.myapplication.control.identify.db.AddressDatabase;
import com.example.myapplication.control.identify.db.HomeAddress;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.InputFilter;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class SearchAddressActivity extends AppCompatActivity{
    private TextView addressName;
    private ListView addresslist;

    private List<HomeAddress> homeAddresses=new ArrayList<>();
    private AddressAdapter addressAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_address);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageView backButton=(ImageView)findViewById(R.id.toolbar_button_search_adress_back);
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        final String phone = "123456";//CustomInfoActivity.oldUser.getUserPhone();
        addresslist=findViewById(R.id.list_address);
        addressAdapter=new AddressAdapter(this,homeAddresses,this.getPackageName());
        addresslist.setAdapter(addressAdapter);
        initData(phone);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "亲，添加新地址", Snackbar.LENGTH_LONG)
                        .setAction("", null).show();

                final EditText inputServer = new EditText(SearchAddressActivity.this);
                inputServer.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                AlertDialog.Builder builder = new AlertDialog.Builder(SearchAddressActivity.this);
                builder.setTitle("请输入地址：").setIcon(android.R.drawable.ic_dialog_info).setView(inputServer)
                        .setNegativeButton("取消", null);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        final String sign = inputServer.getText().toString();

                        if(sign!=null && !sign.isEmpty())
                        {
                            insert(phone,sign);
                            initData(phone);
                        }
                        else
                        {
                            Toast.makeText(SearchAddressActivity.this,"签名为空",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.show();
                
            }
        });
    }

    private void insert(String name,String address) {

        HomeAddress homeAddress = new HomeAddress(name,address);
        homeAddress.setPhone(name);
        homeAddress.setAddress(address);
        AddressDatabase
                .getInstance(this)
                .getAddressDao()
                .insert(homeAddress);
    }

    private List<HomeAddress> query(String phone){
        List<HomeAddress> list=AddressDatabase.getInstance(this).getAddressDao().getAlladdressByUser(phone);
        return list;
    }


    private void initData(String phone) {
        List<HomeAddress> addresses=AddressDatabase
                .getInstance(this)
                .getAddressDao()
                .getAlladdressByUser(phone);
        addressAdapter.setAddressData(addresses);
        addressAdapter.notifyDataSetChanged();
    }
}