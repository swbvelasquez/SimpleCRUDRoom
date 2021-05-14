package com.tutoriales.simplecrudroom.interfaces.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.tutoriales.simplecrudroom.entities.Product;
import com.tutoriales.simplecrudroom.entities.relations.ProductWithBrands;

import java.util.List;

@Dao
public interface ProductDAO {
    @Insert
    long insert(Product product);

    @Query("select * from Product")
    List<Product> getAll();

    @Transaction
    @Query("select * from Product")
    List<ProductWithBrands> getProductWithBrands();
}
