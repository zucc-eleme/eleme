package com.example.myapplication.adapter.InStore;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.bean.Store;
import com.example.myapplication.control.order.ShoppingCartActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StoreAdapter extends BaseAdapter implements Serializable {

    private Context context;
    private List<Store> storesData = new ArrayList<>();

    public StoreAdapter(Context context, List<Store> storesData, String packageName) {
        this.context = context;
    }

    public void setStoresData(List<Store> storesData) {
        this.storesData.clear();
        this.storesData = storesData;
        //数据刷新
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return storesData.size();
    }

    @Override
    public Object getItem(int position) {
        return storesData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.item_customer_in_shop,null);
            viewHolder=new ViewHolder();
            viewHolder.ShopImage=convertView.findViewById(R.id.lv_shop_image);
            viewHolder.StoreName=convertView.findViewById(R.id.lv_store_name);
            viewHolder.StorePhone=convertView.findViewById(R.id.lv_store_phone);
            viewHolder.StoreAddress=convertView.findViewById(R.id.lv_store_address);
            viewHolder.StoreClass=convertView.findViewById(R.id.lv_store_class);
            viewHolder.StoreDelivery=convertView.findViewById(R.id.lv_store_delivery);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder=(ViewHolder) convertView.getTag();
        }
        Store store=storesData.get(position);
        Glide.with(context).load(store.getImagine()).error(R.mipmap.ic_launcher).into(viewHolder.ShopImage);
        viewHolder.StoreName.setText(store.getStoreName());
        viewHolder.StorePhone.setText("联系电话："+store.getStorePhone());
        viewHolder.StoreAddress.setText("地址："+store.getStoreAddress());
        viewHolder.StoreDelivery.setText(store.getDeliveryBegin()+"-"+store.getDeliveryEnd());
        viewHolder.StoreClass.setText("("+store.getStoreClass()+")");
        final Store senditem=store;

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context,store.getStoreName(),Toast.LENGTH_LONG).show();
                Intent intent=new Intent(context, ShoppingCartActivity.class);
                intent.putExtra("store",senditem);
                context.startActivity(intent);
            }
        });
        return convertView;
    }

    class ViewHolder{
        ImageView ShopImage;
        TextView StoreName,StoreAddress,StoreDelivery,StoreClass,StorePhone;
    }

}
