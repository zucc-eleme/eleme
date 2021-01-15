package com.example.myapplication.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class JsonParseGood {
    private static JsonParseGood instance;

    //构造方法私有化
    private JsonParseGood(){};

    //提供一个方法获取实例
    public synchronized static JsonParseGood getInstance(){
        if(instance==null){
            instance=new JsonParseGood();
        }
        return instance;
    }

    public List<Good> getGoodList(String json){
        Type listType=new TypeToken<List<Good>>(){}.getType();
        return (new Gson()).fromJson(json,listType);
    }
}
