package com.tutoriales.simplecrudroom.interfaces.repositories;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.tutoriales.simplecrudroom.entities.Person;

import java.util.List;

public interface IPersonRepository {
    List<Person> getAll();
    Person getById(int id);
    void insert(Person person);
    void insertAll(List<Person> persons);
    void update(Person person);
    void delete(Person person);
}
