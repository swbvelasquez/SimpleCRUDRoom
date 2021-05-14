package com.tutoriales.simplecrudroom.interfaces.repositories;

import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.tutoriales.simplecrudroom.entities.Product;
import com.tutoriales.simplecrudroom.entities.relations.ProductWithBrands;

import java.util.List;

public interface IProductRepository {
    long insert(Product product);
    List<Product> getAll();
    List<ProductWithBrands> getProductWithBrands();
}
