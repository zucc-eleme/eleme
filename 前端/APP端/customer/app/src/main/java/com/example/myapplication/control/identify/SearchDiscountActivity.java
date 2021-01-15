package com.example.myapplication.control.identify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.alibaba.fastjson.JSONArray;
import com.example.myapplication.R;
import com.example.myapplication.adapter.InCustomer.DiscountAdapter;
import com.example.myapplication.bean.Discount;
import com.example.myapplication.util.Contants;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SearchDiscountActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView backButton;
    private ListView discount;
    private DiscountAdapter discountAdapter;
    private List<Discount> disListData=new ArrayList<Discount>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_discount);

        Toolbar toolbar = findViewById(R.id.customer_discount_toolbar);
        setSupportActionBar(toolbar);

        backButton=(ImageView)findViewById(R.id.toolbar_button_search_discount_back);
        discount=(ListView)findViewById(R.id.list_discount);
        discountAdapter =new DiscountAdapter(this,disListData,getPackageName());
        discount.setAdapter(discountAdapter);
        initData();

        backButton.setOnClickListener(this);
    }

    private void initData() {
        int userId= (int) CustomInfoActivity.oldUser.getUserId();
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(Contants.SPRING_USER+"userDiscount/query/discountByUserId?userId="+userId)
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
                Log.v("discount",json);
                final List<Discount> discoutData= JSONArray.parseArray(json,Discount.class);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        discountAdapter.setDiscountData(discoutData);
                    }
                });

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.toolbar_button_search_discount_back:
                finish();
                break;
        }
    }
}