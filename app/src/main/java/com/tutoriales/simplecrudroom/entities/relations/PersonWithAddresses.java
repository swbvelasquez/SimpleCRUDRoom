package com.tutoriales.simplecrudroom.entities.relations;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.tutoriales.simplecrudroom.entities.Address;
import com.tutoriales.simplecrudroom.entities.Person;

import java.util.List;

//relacion de uno a muchos persona con direccion
public class PersonWithAddresses {
    @Embedded
    private Person person;
    @Relation(
            parentColumn = "personId",
            entityColumn = "personId"
    )
    private List<Address> addressList;

    public PersonWithAddresses() {
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    @Override
    public String toString() {
        return "PersonWithAdresses{" +
                "person=" + person +
                ", addressList=" + addressList +
                '}';
    }
}
