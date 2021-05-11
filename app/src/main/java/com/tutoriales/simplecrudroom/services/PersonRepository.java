package com.tutoriales.simplecrudroom.services;

import android.util.Log;

import com.tutoriales.simplecrudroom.entities.Person;
import com.tutoriales.simplecrudroom.interfaces.daos.PersonDAO;
import com.tutoriales.simplecrudroom.interfaces.repositories.IPersonRepository;

import java.util.List;

public class PersonRepository implements IPersonRepository {
    private PersonDAO personDAO=null;

    public PersonRepository(PersonDAO personDAO) {
        this.personDAO = personDAO;
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
    public void insert(Person person) {
        try{
            personDAO.insert(person);
        }catch (Exception ex){
            Log.d("error",ex.getMessage());
        }
    }

    @Override
    public void insertAll(List<Person> persons) {
        try{
            personDAO.insertAll(persons);
        }catch (Exception ex){
            Log.d("error",ex.getMessage());
        }
    }

    @Override
    public void update(Person person) {
        try{
            personDAO.update(person);
        }catch (Exception ex){
            Log.d("error",ex.getMessage());
        }
    }

    @Override
    public void delete(Person person) {
        try{
            personDAO.delete(person);
        }catch (Exception ex){
            Log.d("error",ex.getMessage());
        }
    }
}
