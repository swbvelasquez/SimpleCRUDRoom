package com.tutoriales.simplecrudroom.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Person")
public class Person {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(index = true, name = "personId")
    private int personId;
    @ColumnInfo(name="name") //opcional
    private String name;
    private int age;
    private boolean active;

    public Person() {
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
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
                "id=" + personId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", active=" + active +
                '}';
    }
}
