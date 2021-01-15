package com.example.myapplication.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

//单例
public class JsonParseStore {
    private static JsonParseStore instance;

    //构造方法私有化
    private JsonParseStore(){};

    //提供一个方法获取实例
    public synchronized static JsonParseStore getInstance(){
        if(instance==null){
            instance=new JsonParseStore();
        }
        return instance;
    }

    public List<Store> getStoreList(String json){
        Type listType=new TypeToken<List<Store>>(){}.getType();
        return (new Gson()).fromJson(json,listType);
    }

}
