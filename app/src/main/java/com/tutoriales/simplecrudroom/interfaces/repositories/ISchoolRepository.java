package com.tutoriales.simplecrudroom.interfaces.repositories;

import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.tutoriales.simplecrudroom.entities.Director;
import com.tutoriales.simplecrudroom.entities.School;
import com.tutoriales.simplecrudroom.entities.relations.SchoolAndDirector;

import java.util.List;

public interface ISchoolRepository {
    long insert(School school);
    long insertDirector(Director director);
    List<School> getAll();
    List<SchoolAndDirector> getSchoolAndDirector();
}
