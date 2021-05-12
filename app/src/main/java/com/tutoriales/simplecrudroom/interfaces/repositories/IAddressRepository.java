package com.tutoriales.simplecrudroom.interfaces.repositories;

import com.tutoriales.simplecrudroom.entities.Address;

import java.util.List;

public interface IAddressRepository {
    List<Address> getAll();
    Address getById(int id);
    long insert(Address address);
    List<Long> insertAll(List<Address> addressList);
    int update(Address address);
    int delete(Address address);
}
