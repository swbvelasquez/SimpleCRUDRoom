package com.tutoriales.simplecrudroom.repositories;

import android.content.Context;
import android.util.Log;

import androidx.room.Room;

import com.tutoriales.simplecrudroom.database.AppDataBase;
import com.tutoriales.simplecrudroom.entities.Person;
import com.tutoriales.simplecrudroom.entities.PersonWithAdresses;
import com.tutoriales.simplecrudroom.interfaces.daos.PersonDAO;
import com.tutoriales.simplecrudroom.interfaces.repositories.IPersonRepository;
import com.tutoriales.simplecrudroom.utilities.ConfigurationDB;

import java.util.List;

public class PersonRepository implements IPersonRepository {
    private static PersonDAO personDAO=null;
    public static PersonRepository INSTANCE;

    public PersonRepository() {
    }

    public static PersonRepository getInstance(Context context){
        personDAO = AppDataBase.getInstance(context).personDAO();

        if(INSTANCE==null){
            INSTANCE = new PersonRepository();
        }

        return INSTANCE;
    }

    @Override
    public List<Person> getAll() {
        List<Person> personList=null;

        try{
            personList= personDAO.getAll();
        }catch (Exception ex){
            Log.d("error",ex.getMessage());
        }
        return personList;
    }

    @Override
    public Person getById(int id) {
        Person person=null;

        try{
            person= personDAO.getById(id);
        }catch (Exception ex){
            Log.d("error",ex.getMessage());
        }
        return person;
    }

    @Override
    public long insert(Person person) {
        long id=0;
        try{
            id=personDAO.insert(person);
        }catch (Exception ex){
            Log.d("error",ex.getMessage());
        }
        return id;
    }

    @Override
    public List<Long> insertAll(List<Person> personList) {
        List<Long> idList=null;
        try{
            idList= personDAO.insertAll(personList);
        }catch (Exception ex){
            Log.d("error",ex.getMessage());
        }
        return idList;
    }

    @Override
    public int update(Person person) {
        int count=0;
        try{
           count=personDAO.update(person);
        }catch (Exception ex){
            Log.d("error",ex.getMessage());
        }
        return count;
    }

    @Override
    public int delete(Person person) {
        int count=0;
        try{
            count=personDAO.delete(person);
        }catch (Exception ex){
            Log.d("error",ex.getMessage());
        }
        return count;
    }

    @Override
    public List<PersonWithAdresses> getPersonWithAddresses() {
        List<PersonWithAdresses> personList=null;

        try{
            personList= personDAO.getPersonWithAddresses();
        }catch (Exception ex){
            Log.d("error",ex.getMessage());
        }
        return personList;
    }

    @Override
    public List<PersonWithAdresses> getPersonWithAddressesById(int id) {
        List<PersonWithAdresses> personList=null;

        try{
            personList= personDAO.getPersonWithAddressesById(id);
        }catch (Exception ex){
            Log.d("error",ex.getMessage());
        }
        return personList;
    }
}
