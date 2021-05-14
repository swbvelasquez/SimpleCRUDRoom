package com.tutoriales.simplecrudroom.interfaces.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.tutoriales.simplecrudroom.entities.Brand;
import com.tutoriales.simplecrudroom.entities.relations.BrandWithProducts;

import java.util.List;

@Dao
public interface BrandDAO {
    @Insert
    long insert(Brand brand);

    @Query("select * from Brand")
    List<Brand> getAll();

    @Transaction
    @Query("select * from Brand")
    List<BrandWithProducts> getBrandWithProducts();
}
