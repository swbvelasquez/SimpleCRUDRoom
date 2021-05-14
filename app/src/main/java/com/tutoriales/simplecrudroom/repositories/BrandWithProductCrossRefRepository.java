package com.tutoriales.simplecrudroom.repositories;

import android.content.Context;
import android.util.Log;

import com.tutoriales.simplecrudroom.database.AppDataBase;
import com.tutoriales.simplecrudroom.entities.Brand;
import com.tutoriales.simplecrudroom.entities.relations.BrandWithProductCrossRef;
import com.tutoriales.simplecrudroom.interfaces.daos.BrandDAO;
import com.tutoriales.simplecrudroom.interfaces.daos.BrandWithProductCrossRefDAO;
import com.tutoriales.simplecrudroom.interfaces.repositories.IBrandWithProductCrossRefRepository;

import java.util.List;

public class BrandWithProductCrossRefRepository implements IBrandWithProductCrossRefRepository {
    private static BrandWithProductCrossRefDAO crossRefDAO=null;

    public static BrandRepository INSTANCE;

    public static BrandRepository getInstance(Context context){
        crossRefDAO = AppDataBase.getInstance(context).brandWithProductCrossRefDAO();

        if(INSTANCE==null){
            INSTANCE = new BrandRepository();
        }

        return INSTANCE;
    }

    @Override
    public long insert(BrandWithProductCrossRef crossRef) {
        long id=0;
        try{
            id=crossRefDAO.insert(crossRef);
        }catch (Exception ex){
            Log.d("error",ex.getMessage());
        }
        return id;
    }

    @Override
    public List<BrandWithProductCrossRef> getAllCrossRef() {
        List<BrandWithProductCrossRef> crossRefList=null;

        try{
            crossRefList= crossRefDAO.getAllCrossRef();
        }catch (Exception ex){
            Log.d("error",ex.getMessage());
        }
        return crossRefList;
    }
}
