package com.example.myapplication.control.identify.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

//                    表名         数据库版本     不添加会警告
@Database(entities = {HomeAddress.class}, version = 1, exportSchema = false)
public abstract class AddressDatabase extends RoomDatabase {

    private static final String DB_NAME = "AddressDatabase.db";
    private static volatile AddressDatabase instance;

    public static synchronized AddressDatabase getInstance(Context context) {
        if (instance == null) {
            instance = create(context);
        }
        return instance;
    }

    private static AddressDatabase create(final Context context) {
        return Room.databaseBuilder(
                context,
                AddressDatabase.class,
                DB_NAME)
                .allowMainThreadQueries()
                .build();
    }

    public abstract Dao getAddressDao();

}