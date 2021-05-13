package com.tutoriales.simplecrudroom.interfaces.repositories;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.tutoriales.simplecrudroom.entities.Person;
import com.tutoriales.simplecrudroom.entities.PersonWithAdresses;

import java.util.List;

public interface IPersonRepository {
    List<Person> getAll();
    Person getById(int id);
    long insert(Person person);
    List<Long> insertAll(List<Person> personList);
    int update(Person person);
    int delete(Person person);
    List<PersonWithAdresses> getPersonWithAddresses();
    List<PersonWithAdresses> getPersonWithAddressesById(int id);
    long insertPersonWithAddress(PersonWithAdresses personWithAdresses);
}
