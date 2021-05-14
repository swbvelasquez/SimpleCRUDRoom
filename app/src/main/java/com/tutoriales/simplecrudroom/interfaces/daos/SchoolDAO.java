package com.tutoriales.simplecrudroom.interfaces.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.tutoriales.simplecrudroom.entities.Director;
import com.tutoriales.simplecrudroom.entities.School;
import com.tutoriales.simplecrudroom.entities.relations.SchoolAndDirector;

import java.util.List;

@Dao
public interface SchoolDAO {
    @Insert
    long insert(School school);

    @Insert
    long insertDirector(Director director); //para ahorrar tiempo lo ponemos aqui pero deberia estar en su propio dao

    @Query("select * from School")
    List<School> getAll();

    @Transaction
    @Query("select * from School")
    List<SchoolAndDirector> getSchoolAndDirector();
}
