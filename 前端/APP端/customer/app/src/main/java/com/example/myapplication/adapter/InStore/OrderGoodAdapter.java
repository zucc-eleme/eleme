package com.example.myapplication.adapter.InStore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.bean.GoodsItem;
import com.example.myapplication.bean.Order;
import com.example.myapplication.bean.OrderGood;

import java.util.ArrayList;
import java.util.List;

public class OrderGoodAdapter extends BaseAdapter {
    private Context context;
    private List<OrderGood> orderdetail=new ArrayList<>();

    public OrderGoodAdapter(Context context, List<OrderGood> orders, String packetname){
        this.context=context;
    }

    public void setOrderGoodData(List<OrderGood> list) {
        this.orderdetail.clear();
        this.orderdetail = list;
        //数据刷新
        this.notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return orderdetail.size();
    }

    @Override
    public Object getItem(int position) {
        return orderdetail.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.item_order_detail_good,null);
            viewHolder=new ViewHolder();
            viewHolder.orderDetailGoodName=convertView.findViewById(R.id.order_detail_good_name);
            viewHolder.orderDetailGoodNum=convertView.findViewById(R.id.order_detail_good_num);
            viewHolder.orderDetailGoodPrice=convertView.findViewById(R.id.order_detail_good_price);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder=(ViewHolder)convertView.getTag();
        }

        OrderGood item=orderdetail.get(position);
        viewHolder.orderDetailGoodName.setText(item.getGoodsName());
        viewHolder.orderDetailGoodNum.setText("数量："+String.valueOf(item.getGoodsNum()));
        viewHolder.orderDetailGoodPrice.setText("单价："+String.valueOf(item.getGoodsPrice()));

        return convertView;
    }
    class ViewHolder{
        TextView orderDetailGoodName, orderDetailGoodNum, orderDetailGoodPrice;
    }

}
