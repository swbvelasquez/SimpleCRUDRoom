package com.tutoriales.simplecrudroom.entities;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

//relacion de uno a muchos
public class PersonWithAdresses {
    @Embedded private Person person;
    @Relation(
            parentColumn = "id",
            entityColumn = "personId"
    )
    private List<Address> addressList;

    public PersonWithAdresses() {
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
}
