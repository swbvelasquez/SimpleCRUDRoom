package com.tutoriales.simplecrudroom.repositories;

import android.content.Context;
import android.util.Log;

import com.tutoriales.simplecrudroom.database.AppDataBase;
import com.tutoriales.simplecrudroom.entities.Director;
import com.tutoriales.simplecrudroom.entities.School;
import com.tutoriales.simplecrudroom.entities.relations.SchoolAndDirector;
import com.tutoriales.simplecrudroom.interfaces.daos.SchoolDAO;
import com.tutoriales.simplecrudroom.interfaces.repositories.ISchoolRepository;

import java.util.List;

public class SchoolRepository implements ISchoolRepository {
    private static SchoolDAO schoolDAO=null;

    public static SchoolRepository INSTANCE;

    public static SchoolRepository getInstance(Context context){
        schoolDAO = AppDataBase.getInstance(context).schoolDAO();

        if(INSTANCE==null){
            INSTANCE = new SchoolRepository();
        }

        return INSTANCE;
    }

    @Override
    public List<School> getAll() {
        List<School> schoolList=null;

        try{
            schoolList= schoolDAO.getAll();
        }catch (Exception ex){
            Log.d("error",ex.getMessage());
        }
        return schoolList;
    }

    @Override
    public long insert(School school) {
        long id=0;
        try{
            id=schoolDAO.insert(school);
        }catch (Exception ex){
            Log.d("error",ex.getMessage());
        }
        return id;
    }

    @Override
    public long insertDirector(Director director) {
        long id=0;
        try{
            id=schoolDAO.insertDirector(director);
        }catch (Exception ex){
            Log.d("error",ex.getMessage());
        }
        return id;
    }

    @Override
    public List<SchoolAndDirector> getSchoolAndDirector() {
        List<SchoolAndDirector> schoolAndDirectorList=null;

        try{
            schoolAndDirectorList= schoolDAO.getSchoolAndDirector();
        }catch (Exception ex){
            Log.d("error",ex.getMessage());
        }
        return schoolAndDirectorList;
    }
}
