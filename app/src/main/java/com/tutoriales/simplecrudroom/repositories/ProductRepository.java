package com.tutoriales.simplecrudroom.repositories;

import android.content.Context;
import android.util.Log;

import com.tutoriales.simplecrudroom.database.AppDataBase;
import com.tutoriales.simplecrudroom.entities.Product;
import com.tutoriales.simplecrudroom.entities.relations.ProductWithBrands;
import com.tutoriales.simplecrudroom.interfaces.daos.ProductDAO;
import com.tutoriales.simplecrudroom.interfaces.repositories.IProductRepository;

import java.util.List;

public class ProductRepository implements IProductRepository {
    private static ProductDAO productDAO=null;

    public static ProductRepository INSTANCE;

    public static ProductRepository getInstance(Context context){
        productDAO = AppDataBase.getInstance(context).productDAO();

        if(INSTANCE==null){
            INSTANCE = new ProductRepository();
        }

        return INSTANCE;
    }

    @Override
    public List<Product> getAll() {
        List<Product> productList=null;

        try{
            productList= productDAO.getAll();
        }catch (Exception ex){
            Log.d("error",ex.getMessage());
        }
        return productList;
    }

    @Override
    public long insert(Product product) {
        long id=0;
        try{
            id=productDAO.insert(product);
        }catch (Exception ex){
            Log.d("error",ex.getMessage());
        }
        return id;
    }

    @Override
    public List<ProductWithBrands> getProductWithBrands() {
        List<ProductWithBrands> productWithBrandsList=null;

        try{
            productWithBrandsList= productDAO.getProductWithBrands();
        }catch (Exception ex){
            Log.d("error",ex.getMessage());
        }
        return productWithBrandsList;
    }
}
