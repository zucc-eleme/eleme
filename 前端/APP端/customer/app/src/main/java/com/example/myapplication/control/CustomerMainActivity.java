package com.example.myapplication.control;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.bean.User;
import com.example.myapplication.control.order.MainFragment;
import com.example.myapplication.control.order.OrderFragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.control.identify.CustomInfoActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class CustomerMainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public static User localUserObject;

    private TextView scan,add;
    private Toolbar toolbar;
    private DrawerLayout drawer;//主页布局框
    private ActionBarDrawerToggle toggle;//响应

    public View drawview;//抽屉

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_main);
        toolbar = findViewById(R.id.toolbar_customer_main);
        toolbar.setTitle("首页");
        setSupportActionBar(toolbar);


        //配置抽屉布局
        drawer = (DrawerLayout) findViewById(R.id.user_info);
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        //底部导航监听
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        //设置抽屉导航的选项监听
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        drawview = navigationView.inflateHeaderView(R.layout.nav_header);
        navigationView.setNavigationItemSelectedListener(this);

        MainFragment fragment = new MainFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, fragment).commit();

    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.nav_main:
                    toolbar.setTitle("首页");
                    MainFragment fragment = new MainFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content, fragment).commit();
                    return true;
                case R.id.nav_order:
                    toolbar.setTitle("订单");
                    OrderFragment fragment2 = new OrderFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content, fragment2).commit();
                    return true;
                case R.id.nav_mine:
                    Intent mainToInfo=new Intent(CustomerMainActivity.this, CustomInfoActivity.class);
                    startActivity(mainToInfo);
                    return true;
            }
            return false;
        }

    };

    //打开抽屉时，监听并修改返回键的操作
    @Override
    public void onBackPressed() {
        drawer = (DrawerLayout) findViewById(R.id.user_register);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    //抽屉导航选项的监听
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //选项菜单绑定
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.memu_main, menu);
        return true;
    }

    //选项菜单监听
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_add) {
            Toast.makeText(this, "点击了添加", Toast.LENGTH_SHORT).show();
            return true;
        }else if (id == R.id.action_scan) {
            Toast.makeText(this, "点击了搜索", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}