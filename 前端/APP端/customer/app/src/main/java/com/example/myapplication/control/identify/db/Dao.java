package com.example.myapplication.control.identify.db;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@androidx.room.Dao
public interface Dao {
    @Insert
    void insert(HomeAddress ...addresses);

    @Delete
    void  delete(HomeAddress address);

    @Update
    void  update(HomeAddress...addresses);

    @Query("SELECT * FROM  homeAddress where phone=:phone")
    List<HomeAddress> getAlladdressByUser(String phone);
}
