package com.tutoriales.simplecrudroom.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.tutoriales.simplecrudroom.entities.Person;
import com.tutoriales.simplecrudroom.interfaces.daos.PersonDAO;
import com.tutoriales.simplecrudroom.utilities.ConfigurationDB;

@Database(entities = {Person.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    public static AppDataBase INSTANCE; //Patron singleton

    public abstract PersonDAO personDAO();

    public static AppDataBase getInstance(Context context){

        if(INSTANCE==null){
            INSTANCE = Room.databaseBuilder(context, AppDataBase.class, ConfigurationDB.DB_NAME)
                    .allowMainThreadQueries() //no usar esto, salvo sea prueba, usar corutinas
                    .fallbackToDestructiveMigration() //para no usar migraciones
                    .build();
        }

        return INSTANCE;
    }
}
