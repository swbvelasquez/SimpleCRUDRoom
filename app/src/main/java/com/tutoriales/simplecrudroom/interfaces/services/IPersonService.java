package com.tutoriales.simplecrudroom.interfaces.services;

import com.tutoriales.simplecrudroom.entities.Person;
import com.tutoriales.simplecrudroom.entities.PersonWithAdresses;

import java.util.List;

public interface IPersonService {
    List<Person> getAll();
    Person getById(int id);
    long insert(Person person);
    List<Long> insertAll(List<Person> personList);
    int update(Person person);
    int delete(Person person);
    List<PersonWithAdresses> getPersonWithAddresses();
    List<PersonWithAdresses> getPersonWithAddressesById(int id);
}
