package com.tutoriales.simplecrudroom.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.tutoriales.simplecrudroom.utilities.ConfigurationDB;

@Entity(tableName = ConfigurationDB.DB_TABLE_ADDRESS)
public class Address {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(index = true, name = ConfigurationDB.DB_COLUMN_ADDRESS_ID)
    private int id;
    @ColumnInfo(name = ConfigurationDB.DB_COLUMN_ADDRESS_STREET)
    private String street;
    private String city;
    private String state;
    private int personId;

    public Address() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", personId=" + personId +
                '}';
    }
}
