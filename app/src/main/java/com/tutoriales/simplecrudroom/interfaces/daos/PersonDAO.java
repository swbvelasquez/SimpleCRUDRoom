package com.tutoriales.simplecrudroom.interfaces.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.tutoriales.simplecrudroom.entities.Address;
import com.tutoriales.simplecrudroom.entities.Person;
import com.tutoriales.simplecrudroom.entities.relations.PersonWithAddresses;

import java.util.List;

@Dao
public abstract class PersonDAO {

    //Metodos maestros
    @Query("select * from Person")
    public abstract List<Person> getAll();

    @Query("select * from Person where personId=:id")
    public abstract Person getById(int id);

    @Insert
    public abstract long insert(Person person);

    @Insert
    public abstract List<Long> insertAll(List<Person> personList);

    @Update
    public abstract int update(Person person);

    @Delete
    public abstract int delete(Person person);

    //Metodos con relaciones
    @Transaction // cuando es consultas con una entidad relacionada, hace dos consultas por lo que requiere estar en una transaccion
    @Query("select * from Person")
    public abstract List<PersonWithAddresses> getPersonWithAddresses();

    @Transaction
    @Query("select * from Person where personId=:id")
    public abstract List<PersonWithAddresses> getPersonWithAddressesById(int id);

    @Insert
    public abstract List<Long> insertAddressList (List<Address> addressList);

    @Transaction//cuando es un metodo transaccional, para controlar la consistencia de los movimientos realizados
    public long insertPersonWithAddress(PersonWithAddresses personWithAddresses)
    {
        long id = insert(personWithAddresses.getPerson());

        for(Address address : personWithAddresses.getAddressList()){
            address.setPersonId((int)id);
        }

        insertAddressList(personWithAddresses.getAddressList());

        return id;
    }

}
