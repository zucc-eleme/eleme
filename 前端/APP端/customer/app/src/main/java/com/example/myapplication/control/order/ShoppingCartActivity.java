package com.example.myapplication.control.order;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.bean.Cart;
import com.example.myapplication.bean.DividerDecoration;
import com.example.myapplication.adapter.InStore.GoodsAdapter;
import com.example.myapplication.bean.Good;
import com.example.myapplication.bean.GoodsItem;
import com.example.myapplication.adapter.InStore.SelectAdapter;
import com.example.myapplication.adapter.InStore.TypeAdapter;
import com.example.myapplication.bean.JsonParseGood;
import com.example.myapplication.bean.Order;
import com.example.myapplication.bean.OrderGood;
import com.example.myapplication.bean.Store;
import com.example.myapplication.control.CustomerMainActivity;
import com.example.myapplication.control.LoginCustomerActivity;
import com.example.myapplication.util.Contants;
import com.flipboard.bottomsheet.BottomSheetLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

public class ShoppingCartActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView storeName,storeDeliver,storeAdress,headTitle;
    private ImageView storeImagine,backButton;


    private ImageView imgCart;
    private ViewGroup anim_mask_layout;
    private RecyclerView rvType,rvSelected;
    private TextView tvCount,tvCost,tvSubmit,tvTips;
    private BottomSheetLayout bottomSheetLayout;
    private View bottomSheet;
    private StickyListHeadersListView listView;


    //商品列表
    private static ArrayList<GoodsItem> dataList=new ArrayList<GoodsItem>();
    //分类列表
    private static ArrayList<GoodsItem> typeList=new ArrayList<GoodsItem>();
    //已选择的商品
    private static SparseArray<GoodsItem> selectedList;
    //用于记录每个分组选择的数目
    private static SparseIntArray groupSelect;
    private static List<Good> goods = new ArrayList<Good>();
    private static Store selectedStore;
    private static Order newOrder;

    private GoodsAdapter myAdapter;
    private SelectAdapter selectAdapter;
    private TypeAdapter typeAdapter;

    private NumberFormat nf;
    private Handler mHanlder;
    public long id_1,id_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_detail_view);
        //获取传递
        selectedStore= (Store) getIntent().getSerializableExtra("store");
        if(selectedStore==null){ return; }
        setData();
        id_1=selectedStore.getStoreId();
        id_2=CustomerMainActivity.localUserObject.getUserId();
        upOrder(id_1,id_2);
        nf = NumberFormat.getCurrencyInstance();
        nf.setMaximumFractionDigits(2);
        mHanlder = new Handler(getMainLooper());
        selectedList = new SparseArray<>();
        groupSelect = new SparseIntArray();
        initView();
        searchOrder(id_2);
    }

    //获取商品信息
    private static void setData() {
        dataList=new ArrayList<GoodsItem>();
        typeList=new ArrayList<GoodsItem>();

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(Contants.SPRING_STORE+"goods/list/by/store?storeId="+selectedStore.getStoreId())
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
                List<Good> goodList= new ArrayList<>();
                goodList=JsonParseGood.getInstance().getGoodList(json);

                GoodsItem item=null;
                LinkedHashSet<String> differentClass=new LinkedHashSet<String>();
                for(int i=0;i<goodList.size();i++){
                    differentClass.add(goodList.get(i).getClassName());
                }
                int number=0;
                for(String foodclass : differentClass){
                    for(int j=0;j<goodList.size();j++){
                        Good good=goodList.get(j);
                        if(foodclass.equals(good.getClassName())){
                            item=new GoodsItem((int)good.getGoodsId(), good.getGoodsPrice(), good.getMonthSales(),
                                    good.getGoodsName(), number, good.getClassName(), (int)good.getHighRating());
                            dataList.add(item);}
                    }
                    typeList.add(item);
                    number++;
                }
            }
        });
    }

    //视图绑定
    private void initView(){
        Toolbar toolbar = findViewById(R.id.toolbar_customer_info);
        setSupportActionBar(toolbar);
        headTitle=findViewById(R.id.tv_back_store_detail);
        backButton=findViewById(R.id.toolbar_button_store_detail_back);
        storeName=findViewById(R.id.head_store_name);
        storeDeliver=findViewById(R.id.head_store_delivery);
        storeAdress=findViewById(R.id.head_store_adress);
        storeImagine=findViewById(R.id.head_store_picture);
        tvCount = (TextView) findViewById(R.id.tvCount);
        tvCost = (TextView) findViewById(R.id.tvCost);
        tvTips = (TextView) findViewById(R.id.tvTips);
        tvSubmit  = (TextView) findViewById(R.id.tvSubmit);
        rvType = (RecyclerView) findViewById(R.id.type_goodClass_recyclerView);
        imgCart = (ImageView) findViewById(R.id.imgCart);
        anim_mask_layout = (RelativeLayout) findViewById(R.id.containerLayout);
        bottomSheetLayout = (BottomSheetLayout) findViewById(R.id.bottomSheetLayout);
        listView = (StickyListHeadersListView) findViewById(R.id.item_good_listView);


        headTitle.setText("店铺详情");
        backButton.setOnClickListener(this);
        storeName.setText(selectedStore.getStoreName());
        storeAdress.setText("地址："+selectedStore.getStoreAddress());
        storeDeliver.setText(selectedStore.getDeliveryBegin()+"-"+selectedStore.getDeliveryEnd());
        Glide.with(this).load(selectedStore.getImagine())
                .error(R.mipmap.ic_launcher)
                .into(storeImagine);

        rvType.setLayoutManager(new LinearLayoutManager(this));
        typeAdapter = new TypeAdapter(this,typeList);
        rvType.setAdapter(typeAdapter);
        rvType.addItemDecoration(new DividerDecoration(this));

        myAdapter = new GoodsAdapter(dataList,this);
        listView.setAdapter(myAdapter);

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if(dataList.isEmpty())
                    return;
                GoodsItem item = dataList.get(firstVisibleItem);
                if(typeAdapter.selectTypeId != item.typeId) {
                    typeAdapter.selectTypeId = item.typeId;
                    typeAdapter.notifyDataSetChanged();
                    rvType.smoothScrollToPosition(getSelectedGroupPosition(item.typeId));
                }
            }
        });

    }

    //动画
    public void playAnimation(int[] start_location){
        ImageView img = new ImageView(this);
        img.setImageResource(R.drawable.button_add);
        setAnim(img,start_location);
    }

    private Animation createAnim(int startX,int startY){
        int[] des = new int[2];
        imgCart.getLocationInWindow(des);

        AnimationSet set = new AnimationSet(false);

        Animation translationX = new TranslateAnimation(0, des[0]-startX, 0, 0);
        translationX.setInterpolator(new LinearInterpolator());
        Animation translationY = new TranslateAnimation(0, 0, 0, des[1]-startY);
        translationY.setInterpolator(new AccelerateInterpolator());
        Animation alpha = new AlphaAnimation(1,0.5f);
        set.addAnimation(translationX);
        set.addAnimation(translationY);
        set.addAnimation(alpha);
        set.setDuration(500);

        return set;
    }

    private void addViewToAnimLayout(final ViewGroup vg, final View view,
                                     int[] location) {

        int x = location[0];
        int y = location[1];
        int[] loc = new int[2];
        vg.getLocationInWindow(loc);
        view.setX(x);
        view.setY(y-loc[1]);
        vg.addView(view);
    }

    private void setAnim(final View v, int[] start_location) {

        addViewToAnimLayout(anim_mask_layout, v, start_location);
        Animation set = createAnim(start_location[0],start_location[1]);
        set.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(final Animation animation) {
                mHanlder.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        anim_mask_layout.removeView(v);
                    }
                },100);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        v.startAnimation(set);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.toolbar_button_store_detail_back:
                finish();
                break;
            case R.id.bottom_shopping_car:
                showBottomSheet();
                break;
            case R.id.clear:
                clearCart();
                break;
            case R.id.tvSubmit:
                final long myId=newOrder.getOrdId();
                List<OrderGood> listSend=new ArrayList<>();
                for(int i=0;i<selectedList.size();i++){
                    int key=selectedList.keyAt(i);
                    OrderGood item2=new OrderGood();
                    String name=selectedList.get(key).getName();
                    int count=selectedList.get(key).getCount();
                    double price=selectedList.get(key).getPrice();
                    item2.setOrdId(myId);
                    item2.setGoodsName(name);
                    item2.setGoodsNum(count);
                    item2.setGoodsPrice(price);
                    listSend.add(item2);
                }
                sendOrderGood(listSend);
                Toast.makeText(ShoppingCartActivity.this, "结算", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(ShoppingCartActivity.this,OrderDetailActivity.class);
                intent.putExtra("order",newOrder);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    public void upOrder(final long storeId, final long userId){
        new Thread(new Runnable() {
            @Override
            public void run() { //类型2——Param型
                try {
                    FormBody.Builder params = new FormBody.Builder();
                    params.add("storeId",""+storeId);
                    params.add("userId",""+userId);//添加url参数
                    OkHttpClient client = new OkHttpClient(); //创建http客户端
                    Request request = new Request.Builder()
                            .url(Contants.SPRING_STORE +"ord/add") //后端请求接口的地址
                            .post(params.build()).build(); //创建http请求
                    Response response = client.newCall(request).execute(); //执行发送指令
                    String responseData = response.body().string(); //获取后端接口返回过来的JSON格式的结果

                }catch (Exception e){
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(ShoppingCartActivity.this,"网络请求失败！",Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        }).start();
    }

    public void searchOrder(final long userId){
        new Thread(){
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .get()
                            .url(Contants.SPRING_STORE + "ord/search/by/user?userId="+userId)
                            .build();
                    Response response = client.newCall(request).execute();//回调
                    String order = response.body().string();
                    final String finalOrder=order;
                    final List<Order> list= JSONArray.parseArray(finalOrder,Order.class);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                                newOrder=list.get(list.size()-1);
                        }
                    });
                }catch (IOException e)
                { e.printStackTrace(); }
            }
        }.start();
    }

    public void sendOrderGood(final List<OrderGood> list){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        String json = new Gson().toJson(list); //创建HTTP客户端
                        OkHttpClient client = new OkHttpClient();
                        Request request = new Request.Builder()
                                .url(Contants.SPRING_STORE + "/comment/add") //后端请求接口的路径
                                .post(RequestBody.create(MediaType.parse("application/json"), json)) //发送JSON格式的body
                                .build(); //创造http请求
                        Response response = client.newCall(request).execute(); //执行发送指令
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }).start();

    }

    //添加商品
    public void add(GoodsItem item,boolean refreshGoodList){

        int groupCount = groupSelect.get(item.typeId);
        if(groupCount==0){
            groupSelect.append(item.typeId,1);
        }else{
            groupSelect.append(item.typeId,++groupCount);

        }

        GoodsItem temp = selectedList.get(item.id);
        if(temp==null){
            item.count=1;
            selectedList.append(item.id,item);
        }else{
            temp.count++;
        }
        update(refreshGoodList);
    }
    //移除商品
    public void remove(GoodsItem item,boolean refreshGoodList){

        int groupCount = groupSelect.get(item.typeId);
        if(groupCount==1){
            groupSelect.delete(item.typeId);
        }else if(groupCount>1){
            groupSelect.append(item.typeId,--groupCount);
        }

        GoodsItem temp = selectedList.get(item.id);
        if(temp!=null){
            if(temp.count<2){
                selectedList.remove(item.id);
            }else{
                item.count--;
            }
        }
        update(refreshGoodList);
    }
    //刷新布局 总价、购买数量等
    private void update(boolean refreshGoodList){
        int size = selectedList.size();
        int count =0;
        double cost = 0;
        for(int i=0;i<size;i++){
            GoodsItem item = selectedList.valueAt(i);
            count += item.count;
            cost += item.count*item.price;
        }

        //显示总价
        if(count<1){
            imgCart.setImageDrawable(getResources().getDrawable(R.drawable.shop_car_empty));
            tvCount.setVisibility(View.GONE);
        }else{
            imgCart.setImageDrawable(getResources().getDrawable(R.drawable.shop_car));
            tvCount.setVisibility(View.VISIBLE);
        }
        tvCount.setText(String.valueOf(count));

        //定义起送价
        if(cost > 29.9){
            tvTips.setVisibility(View.GONE);
            tvSubmit.setVisibility(View.VISIBLE);
        }else{
            tvSubmit.setVisibility(View.GONE);
            tvTips.setVisibility(View.VISIBLE);
        }
        tvCost.setText(nf.format(cost));

        //刷新布局
        if(myAdapter!=null && refreshGoodList){
            myAdapter.notifyDataSetChanged();
        }
        if(selectAdapter!=null){
            selectAdapter.notifyDataSetChanged();
        }
        if(typeAdapter!=null){
            typeAdapter.notifyDataSetChanged();
        }
        if(bottomSheetLayout.isSheetShowing() && selectedList.size()<1){
            bottomSheetLayout.dismissSheet();
        }
    }
    //清空购物车
    public void clearCart(){
        selectedList.clear();
        groupSelect.clear();
        update(true);

    }
    //根据商品id获取当前商品的采购数量
    public int getSelectedItemCountById(int id){
        GoodsItem temp = selectedList.get(id);
        if(temp==null){
            return 0;
        }
        return temp.count;
    }
    //根据类别Id获取属于当前类别的数量
    public int getSelectedGroupCountByTypeId(int typeId){
        return groupSelect.get(typeId);
    }
    //根据类别id获取分类的Position 用于滚动左侧的类别列表
    public int getSelectedGroupPosition(int typeId){
        for(int i=0;i<typeList.size();i++){
            if(typeId==typeList.get(i).typeId){
                return i;
            }
        }
        return 0;
    }

    public void onTypeClicked(int typeId){
        listView.setSelection(getSelectedPosition(typeId));
    }

    private int getSelectedPosition(int typeId){
        int position = 0;
        for(int i=0;i<dataList.size();i++){
            if(dataList.get(i).typeId == typeId){
                position = i;
                break;
            }
        }
        return position;
    }

    private View createBottomSheetView(){
        View view = LayoutInflater.from(this).inflate(R.layout.layout_bottom_sheet,(ViewGroup) getWindow().getDecorView(),false);
        rvSelected = (RecyclerView) view.findViewById(R.id.selectRecyclerView);
        rvSelected.setLayoutManager(new LinearLayoutManager(this));
        TextView clear = (TextView) view.findViewById(R.id.clear);
        clear.setOnClickListener(this);
        selectAdapter = new SelectAdapter(this,selectedList);
        rvSelected.setAdapter(selectAdapter);
        return view;
    }

    private void showBottomSheet(){
        if(bottomSheet==null){
            bottomSheet = createBottomSheetView();
        }
        if(bottomSheetLayout.isSheetShowing()){
            bottomSheetLayout.dismissSheet();
        }else {
            if(selectedList.size()!=0){
                bottomSheetLayout.showWithSheetView(bottomSheet);
            }
        }
    }
}
