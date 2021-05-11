package com.tutoriales.simplecrudroom.interfaces.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.tutoriales.simplecrudroom.entities.Person;

import java.util.List;

@Dao
public interface PersonDAO {
    @Query("select * from Person")
    List<Person> getAll();

    @Query("select * from Person where id=:id")
    Person getById(int id);

    @Insert
    void insert(Person person);

    @Insert
    void insertAll(List<Person> persons);

    @Update
    void update(Person person);

    @Delete
    void delete(Person person);
}
