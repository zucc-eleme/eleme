package com.example.myapplication.adapter.InStore;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.bean.Order;
import com.example.myapplication.control.order.OrderDetailActivity;
import com.example.myapplication.control.order.ShoppingCartActivity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class OrderAdapter extends BaseAdapter implements Serializable{
    private Context context;
    private List<Order> orders=new ArrayList<Order>();

    public OrderAdapter(Context context,List<Order> orders,String packetname){
        this.context=context;
    }

    public void setOrderData(List<Order> list) {
        this.orders.clear();
        this.orders = list;
        //数据刷新
        this.notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return orders.size();
    }

    @Override
    public Object getItem(int position) {
        return orders.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.item_order,null);
            viewHolder=new OrderAdapter.ViewHolder();
            viewHolder.itemOrderShopId=convertView.findViewById(R.id.item_order_shop_id);
            viewHolder.itemOrderShopName=convertView.findViewById(R.id.item_order_shop_name);
            viewHolder.itemOrderShopPrice=convertView.findViewById(R.id.item_order_shop_price);
            viewHolder.itemOrderTime=convertView.findViewById(R.id.item_order_time);
            viewHolder.orderDetailReturn=convertView.findViewById(R.id.item_order_detail_return);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder=(ViewHolder)convertView.getTag();
        }

        Order order=orders.get(position);
        String data=new SimpleDateFormat(new String("yyyy-MM-dd HH:mm:ss")).format(order.getOrdTime());
        String isRe=null;
        switch (order.getIsReturn()){
            case 0:
                isRe="无效订单";
                break;
            case 1:
                isRe="未送达";
                break;
            case 2:
                isRe="已退单";
                break;
            case 3:
                isRe="已送达";
                break;}

        viewHolder.itemOrderShopId.setText("订单号："+String.valueOf(order.getOrdId()));
        viewHolder.itemOrderShopName.setText("商品号："+String.valueOf(order.getStoreId()));
        viewHolder.itemOrderShopPrice.setText("总价"+String.valueOf(order.getTotalMoney()-order.getTotalDiscount()));
        viewHolder.itemOrderTime.setText("下单时间："+data);
        viewHolder.orderDetailReturn.setText("订单状态："+isRe);

        final Order intentOrder=order;
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context,store.getStoreName(),Toast.LENGTH_LONG).show();
                Intent intento=new Intent(context, OrderDetailActivity.class);
                intento.putExtra("order", intentOrder);
                context.startActivity(intento);
            }
        });

        return convertView;
    }

    class ViewHolder{
        TextView itemOrderShopId, itemOrderShopName, itemOrderTime, itemOrderShopPrice, orderDetailReturn;
    }
}
