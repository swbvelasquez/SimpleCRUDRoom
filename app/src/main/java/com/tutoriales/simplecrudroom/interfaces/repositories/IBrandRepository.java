package com.tutoriales.simplecrudroom.interfaces.repositories;

import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.tutoriales.simplecrudroom.entities.Brand;
import com.tutoriales.simplecrudroom.entities.relations.BrandWithProducts;

import java.util.List;

public interface IBrandRepository {
    long insert(Brand brand);
    List<Brand> getAll();
    List<BrandWithProducts> getBrandWithProducts();
}
