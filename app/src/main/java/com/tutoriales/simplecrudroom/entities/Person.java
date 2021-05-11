package com.tutoriales.simplecrudroom.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.tutoriales.simplecrudroom.utilities.ConfigurationDB;

@Entity(tableName = ConfigurationDB.DB_TABLE_PERSON)
public class Person {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(index = true, name = ConfigurationDB.DB_COLUMN_PERSON_ID)
    private int id;
    @ColumnInfo(name = ConfigurationDB.DB_COLUMN_PERSON_NAME) //opcional
    private String name;
    private int age;
    private boolean active;

    public Person() {
    }

    public Person(int id, String name, int age, boolean active) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", active=" + active +
                '}';
    }
}
