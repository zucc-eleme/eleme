package com.example.myapplication.adapter.InCustomer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.ContentView;

import com.example.myapplication.R;
import com.example.myapplication.bean.Discount;
import com.example.myapplication.bean.Store;

import java.util.ArrayList;
import java.util.List;

public class DiscountAdapter extends BaseAdapter {
    private Context context;
    private List<Discount> list = new ArrayList<Discount>();

    public DiscountAdapter(Context context, List<Discount> list, String packageName) {
        this.context = context;
    }

    public void setDiscountData(List<Discount> list) {
        this.list.clear();
        this.list = list;
        //数据刷新
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHold viewHold=null;
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.item_discount,null);
            viewHold=new ViewHold();
            viewHold.disName=convertView.findViewById(R.id.discount_name);
            viewHold.disPrice=convertView.findViewById(R.id.discount_price);
            viewHold.disDayline=convertView.findViewById(R.id.discount_deadprice);
            convertView.setTag(viewHold);

        }
        else{
            viewHold=(ViewHold)convertView.getTag();
        }

        Discount discount=list.get(position);
        viewHold.disName.setText(discount.getDiscountName());
        viewHold.disPrice.setText("¥"+String.valueOf(discount.getDiscountMoney()));
        viewHold.disDayline.setText("满"+String.valueOf(discount.getStartMoney())+"元可用");

        return convertView;
    }

    class ViewHold{
        TextView disName,disPrice,disDayline;
    }

}
