package com.tutoriales.simplecrudroom.repositories;

import android.content.Context;
import android.util.Log;

import com.tutoriales.simplecrudroom.database.AppDataBase;
import com.tutoriales.simplecrudroom.entities.Brand;
import com.tutoriales.simplecrudroom.entities.relations.BrandWithProducts;
import com.tutoriales.simplecrudroom.entities.relations.ProductWithBrands;
import com.tutoriales.simplecrudroom.interfaces.daos.BrandDAO;
import com.tutoriales.simplecrudroom.interfaces.repositories.IBrandRepository;

import java.util.List;

public class BrandRepository implements IBrandRepository {
    private static BrandDAO brandDAO=null;

    public static BrandRepository INSTANCE;

    public static BrandRepository getInstance(Context context){
        brandDAO = AppDataBase.getInstance(context).brandDAO();

        if(INSTANCE==null){
            INSTANCE = new BrandRepository();
        }

        return INSTANCE;
    }

    @Override
    public List<Brand> getAll() {
        List<Brand> brandList=null;

        try{
            brandList= brandDAO.getAll();
        }catch (Exception ex){
            Log.d("error",ex.getMessage());
        }
        return brandList;
    }

    @Override
    public long insert(Brand brand) {
        long id=0;
        try{
            id=brandDAO.insert(brand);
        }catch (Exception ex){
            Log.d("error",ex.getMessage());
        }
        return id;
    }

    @Override
    public List<BrandWithProducts> getBrandWithProducts() {
        List<BrandWithProducts> brandWithProducts=null;

        try{
            brandWithProducts= brandDAO.getBrandWithProducts();
        }catch (Exception ex){
            Log.d("error",ex.getMessage());
        }
        return brandWithProducts;
    }
}
