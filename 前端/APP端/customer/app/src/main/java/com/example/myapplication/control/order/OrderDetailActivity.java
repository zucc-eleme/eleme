package com.example.myapplication.control.order;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.alibaba.fastjson.JSONArray;
import com.example.myapplication.R;
import com.example.myapplication.adapter.InStore.OrderGoodAdapter;
import com.example.myapplication.bean.Cart;
import com.example.myapplication.bean.Good;
import com.example.myapplication.bean.GoodsItem;
import com.example.myapplication.bean.JsonParseGood;
import com.example.myapplication.bean.Order;
import com.example.myapplication.bean.OrderGood;
import com.example.myapplication.control.CustomerMainActivity;
import com.example.myapplication.control.identify.SearchAddressActivity;
import com.example.myapplication.control.identify.SearchDiscountActivity;
import com.example.myapplication.util.Contants;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OrderDetailActivity extends AppCompatActivity implements View.OnClickListener {

    private static Order order;
    private ListView listGoodDetail;
    private OrderGoodAdapter adapter;
    private List<OrderGood> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_detail);
        order=(Order) getIntent().getSerializableExtra("order");

        ImageView back=(ImageView)findViewById(R.id.order_detail_back);
        back.setOnClickListener(this);

        ImageView order_detail_add=(ImageView)findViewById(R.id.order_detail_add);
        order_detail_add.setOnClickListener(this);
        TextView returnitem=(TextView)findViewById(R.id.toolbar_order_detail_title);
        TextView orderAgain=(TextView)findViewById(R.id.order_again);
        orderAgain.setOnClickListener(this);
        TextView orderId=(TextView)findViewById(R.id.order_id);
        TextView orderTime=(TextView)findViewById(R.id.order_time);
        TextView orderStoreDetailName=(TextView)findViewById(R.id.order_store_detail_name);
        TextView orderDetailPriceCount=(TextView)findViewById(R.id.order_detail_price_count);
        ListView orderGood=(ListView)findViewById(R.id.order_good_list);
        adapter=new OrderGoodAdapter(this,list,getPackageName());
        orderGood.setAdapter(adapter);
        setData();

        if(order.getIsReturn()==3){
            returnitem.setText("订单已送达");
            orderAgain.setVisibility(View.VISIBLE);
        }else{
            orderAgain.setVisibility(View.GONE);
            if(order.getIsReturn()==2)
                returnitem.setText("已退单");
            else if(order.getIsReturn()==1)
                returnitem.setText("未送达");
            else if(order.getIsReturn()==0)
                returnitem.setText("无效订单");
        }
        orderTime.setText(new SimpleDateFormat(new String("yyyy-MM-dd HH:mm:ss")).format(order.getOrdTime()));
        orderId.setText("订单号："+order.getOrdId());
        orderStoreDetailName.setText("商家编号："+order.getStoreId());
        orderDetailPriceCount.setText("实付"+order.getTotalMoney()+"元   ");



    }

    private void setData() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(Contants.SPRING_STORE+"ordGoods/goods/by/ord?ordId="+order.getOrdId())
                .get()
                .build();
        Call call=client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String json = response.body().string();
                List<OrderGood> goodList= new ArrayList<>();
                goodList= JSONArray.parseArray(json,OrderGood.class);
                final List<OrderGood> finalGoodList = goodList;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.setOrderGoodData(finalGoodList);
                    }
                });
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.order_detail_back:
                Intent intent=new Intent(OrderDetailActivity.this, CustomerMainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.order_again:
                Intent intent1=new Intent(OrderDetailActivity.this, CustomerMainActivity.class);
                startActivity(intent1);
                finish();
            case R.id.order_detail_add:
                Intent intent2=new Intent(OrderDetailActivity.this, SearchDiscountActivity.class);
                startActivity(intent2);
        }
    }
}