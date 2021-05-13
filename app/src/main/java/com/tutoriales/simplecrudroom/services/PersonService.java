package com.tutoriales.simplecrudroom.services;

import android.content.Context;
import android.util.Log;

import com.tutoriales.simplecrudroom.database.AppDataBase;
import com.tutoriales.simplecrudroom.entities.Address;
import com.tutoriales.simplecrudroom.entities.Person;
import com.tutoriales.simplecrudroom.entities.PersonWithAdresses;
import com.tutoriales.simplecrudroom.interfaces.daos.PersonDAO;
import com.tutoriales.simplecrudroom.interfaces.services.IPersonService;
import com.tutoriales.simplecrudroom.repositories.AddressRepository;
import com.tutoriales.simplecrudroom.repositories.PersonRepository;

import java.util.List;

public class PersonService implements IPersonService {

    private static PersonRepository personRepository=null;
    private static AddressRepository addressRepository=null;
    public static PersonService INSTANCE;

    public PersonService() {
    }

    public static PersonService getInstance(Context context){
        personRepository = PersonRepository.getInstance(context);
        addressRepository = AddressRepository.getInstance(context);

        if(INSTANCE==null){
            INSTANCE = new PersonService();
        }

        return INSTANCE;
    }

    @Override
    public List<Person> getAll() {
        List<Person> personList=null;

        try{
            personList= personRepository.getAll();
        }catch (Exception ex){
            Log.d("error",ex.getMessage());
        }
        return personList;
    }

    @Override
    public Person getById(int id) {
        Person person=null;

        try{
            person= personRepository.getById(id);
        }catch (Exception ex){
            Log.d("error",ex.getMessage());
        }
        return person;
    }

    @Override
    public long insert(Person person) {
        long id=0;
        try{
            id=personRepository.insert(person);
        }catch (Exception ex){
            Log.d("error",ex.getMessage());
        }
        return id;
    }

    @Override
    public List<Long> insertAll(List<Person> personList) {
        List<Long> idList=null;
        try{
            idList= personRepository.insertAll(personList);
        }catch (Exception ex){
            Log.d("error",ex.getMessage());
        }
        return idList;
    }

    @Override
    public int update(Person person) {
        int count=0;
        try{
            count=personRepository.update(person);
        }catch (Exception ex){
            Log.d("error",ex.getMessage());
        }
        return count;
    }

    @Override
    public int delete(Person person) {
        int count=0;
        try{
            count=personRepository.delete(person);
        }catch (Exception ex){
            Log.d("error",ex.getMessage());
        }
        return count;
    }

    @Override
    public List<PersonWithAdresses> getPersonWithAddresses() {
        List<PersonWithAdresses> personList=null;

        try{
            personList= personRepository.getPersonWithAddresses();
        }catch (Exception ex){
            Log.d("error",ex.getMessage());
        }
        return personList;
    }

    @Override
    public List<PersonWithAdresses> getPersonWithAddressesById(int id) {
        List<PersonWithAdresses> personList=null;

        try{
            personList= personRepository.getPersonWithAddressesById(id);
        }catch (Exception ex){
            Log.d("error",ex.getMessage());
        }
        return personList;
    }

    @Override
    public long insertPersonWithAddress(PersonWithAdresses personWithAdresses) {
        long id=0;
        try{
            id=personRepository.insertPersonWithAddress(personWithAdresses);
        }catch (Exception ex){
            Log.d("error",ex.getMessage());
        }
        return id;
    }
}
