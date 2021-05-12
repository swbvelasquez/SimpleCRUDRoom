package com.tutoriales.simplecrudroom.repositories;

import android.content.Context;
import android.util.Log;

import com.tutoriales.simplecrudroom.database.AppDataBase;
import com.tutoriales.simplecrudroom.entities.Address;
import com.tutoriales.simplecrudroom.entities.Address;
import com.tutoriales.simplecrudroom.interfaces.daos.AddressDAO;
import com.tutoriales.simplecrudroom.interfaces.daos.AddressDAO;
import com.tutoriales.simplecrudroom.interfaces.repositories.IAddressRepository;

import java.util.List;

public class AddressRepository implements IAddressRepository {

    private static AddressDAO addressDAO=null;

    public static AddressRepository INSTANCE;

    public static AddressRepository getInstance(Context context){
        addressDAO = AppDataBase.getInstance(context).addressDAO();

        if(INSTANCE==null){
            INSTANCE = new AddressRepository();
        }

        return INSTANCE;
    }

    @Override
    public List<Address> getAll() {
        List<Address> addressList=null;

        try{
            addressList= addressDAO.getAll();
        }catch (Exception ex){
            Log.d("error",ex.getMessage());
        }
        return addressList;
    }

    @Override
    public Address getById(int id) {
        Address address=null;

        try{
            address= addressDAO.getById(id);
        }catch (Exception ex){
            Log.d("error",ex.getMessage());
        }
        return address;
    }

    @Override
    public long insert(Address address) {
        long id=0;
        try{
            id=addressDAO.insert(address);
        }catch (Exception ex){
            Log.d("error",ex.getMessage());
        }
        return id;
    }

    @Override
    public List<Long> insertAll(List<Address> addressList) {
        List<Long> idList=null;
        try{
            idList= addressDAO.insertAll(addressList);
        }catch (Exception ex){
            Log.d("error",ex.getMessage());
        }
        return idList;
    }

    @Override
    public int update(Address address) {
        int count=0;
        try{
            count=addressDAO.update(address);
        }catch (Exception ex){
            Log.d("error",ex.getMessage());
        }
        return count;
    }

    @Override
    public int delete(Address address) {
        int count=0;
        try{
            count=addressDAO.delete(address);
        }catch (Exception ex){
            Log.d("error",ex.getMessage());
        }
        return count;
    }
}
