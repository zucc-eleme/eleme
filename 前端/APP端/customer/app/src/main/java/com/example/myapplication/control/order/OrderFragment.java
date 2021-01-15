package com.example.myapplication.control.order;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.alibaba.fastjson.JSONArray;
import com.example.myapplication.R;
import com.example.myapplication.adapter.InStore.OrderAdapter;
import com.example.myapplication.bean.Order;
import com.example.myapplication.bean.User;
import com.example.myapplication.control.CustomerMainActivity;
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

public class OrderFragment extends Fragment {
    private ListView ordlist;
    private OrderAdapter orderAdapter;
    private List<Order> ordersData = new ArrayList<>();
    public static User myUser=null;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_order, container, false);
        ordlist=(ListView)view.findViewById(R.id.list_order);
        orderAdapter =new OrderAdapter(getActivity(),ordersData,getActivity().getPackageName());
        ordlist.setAdapter(orderAdapter);
        initData();

        return view;
    }

    private void initData() {
        myUser= CustomerMainActivity.localUserObject;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(Contants.SPRING_STORE+"ord/search/by/user?userId="+myUser.getUserId())
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
                final List<Order> orderList= JSONArray.parseArray(json,Order.class);
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        orderAdapter.setOrderData(orderList);
                    }
                });

            }
        });
    }

}
