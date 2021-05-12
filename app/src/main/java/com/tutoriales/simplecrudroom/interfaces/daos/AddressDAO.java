package com.tutoriales.simplecrudroom.interfaces.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.tutoriales.simplecrudroom.entities.Address;

import java.util.List;

@Dao
public abstract class AddressDAO {
    @Query("select * from Address")
    public abstract List<Address> getAll();

    @Query("select * from Address where id=:id")
    public abstract Address getById(int id);

    @Insert
    public abstract long insert(Address address);

    @Insert
    public abstract List<Long> insertAll(List<Address> addressList);

    @Update
    public abstract int update(Address address);

    @Delete
    public abstract int delete(Address address);
}
