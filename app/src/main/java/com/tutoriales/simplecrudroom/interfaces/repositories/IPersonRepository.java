package com.tutoriales.simplecrudroom.interfaces.repositories;

import com.tutoriales.simplecrudroom.entities.Person;
import com.tutoriales.simplecrudroom.entities.relations.PersonWithAddresses;

import java.util.List;

public interface IPersonRepository {
    List<Person> getAll();
    Person getById(int id);
    long insert(Person person);
    List<Long> insertAll(List<Person> personList);
    int update(Person person);
    int delete(Person person);
    List<PersonWithAddresses> getPersonWithAddresses();
    List<PersonWithAddresses> getPersonWithAddressesById(int id);
    long insertPersonWithAddress(PersonWithAddresses personWithAddresses);
}
