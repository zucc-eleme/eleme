package com.example.myapplication.adapter.InCustomer;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.example.myapplication.R;
import com.example.myapplication.control.identify.db.AddressDatabase;
import com.example.myapplication.control.identify.db.HomeAddress;

import java.util.ArrayList;
import java.util.List;

public class AddressAdapter extends BaseAdapter {
    private Context context;
    private List<HomeAddress> list=new ArrayList<>();

    public AddressAdapter(Context context, List<HomeAddress> list, String packageName) {
        this.context = context;
    }

    public void setAddressData(List<HomeAddress> list) {
        this.list.clear();
        this.list = list;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHold viewHold=null;
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.item_address,null);
            viewHold=new ViewHold();
            viewHold.address =convertView.findViewById(R.id.search_address_name);
            convertView.setTag(viewHold);
        }
        else{
            viewHold=(ViewHold)convertView.getTag();
        }
        final HomeAddress address=list.get(position);
        viewHold.address.setText(address.getAddress());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("是否确认删除地址").setIcon(R.drawable.icon_clear)
                        .setNegativeButton("取消", null);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        delete(address);

                    }
                });
                builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        List<HomeAddress> addresses=AddressDatabase
                                .getInstance(context)
                                .getAddressDao()
                                .getAlladdressByUser(list.get(position).getPhone());
                        setAddressData(addresses);
                        notifyDataSetChanged();
                    }
                });
                builder.show();


            }
        });
        return convertView;
    }

    class ViewHold{
        TextView  address;
    }

    private void delete(HomeAddress delete){
        AddressDatabase
                .getInstance(context)
                .getAddressDao()
                .delete(delete);

    }

}
