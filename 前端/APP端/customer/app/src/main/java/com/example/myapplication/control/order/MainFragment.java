package com.example.myapplication.control.order;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.adapter.InStore.StoreAdapter;
import com.example.myapplication.bean.JsonParseStore;
import com.example.myapplication.bean.Store;
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

public class MainFragment extends Fragment {
    private ListView shopList;
    private StoreAdapter shopAdapter;
    private List<Store> storesData = new ArrayList<>();


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        shopList=(ListView)view.findViewById(R.id.lv_shop_listView_main);


        shopAdapter =new StoreAdapter(getActivity(),storesData,getActivity().getPackageName());
        shopList.setAdapter(shopAdapter);
        initData();
        shopAdapter.notifyDataSetChanged();
        return view;
    }

    private void initData() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(Contants.SPRING_STORE+"store/allStore")
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
                Log.v("asdf","json:"+json);
                final List<Store> storeList= JsonParseStore.getInstance().getStoreList(json);
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        shopAdapter.setStoresData(storeList);
                    }
                });

            }
        });
    }

}



