package com.tutoriales.simplecrudroom.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.tutoriales.simplecrudroom.entities.Address;
import com.tutoriales.simplecrudroom.entities.Brand;
import com.tutoriales.simplecrudroom.entities.Director;
import com.tutoriales.simplecrudroom.entities.Person;
import com.tutoriales.simplecrudroom.entities.Product;
import com.tutoriales.simplecrudroom.entities.School;
import com.tutoriales.simplecrudroom.entities.relations.BrandWithProductCrossRef;
import com.tutoriales.simplecrudroom.interfaces.daos.AddressDAO;
import com.tutoriales.simplecrudroom.interfaces.daos.BrandDAO;
import com.tutoriales.simplecrudroom.interfaces.daos.PersonDAO;
import com.tutoriales.simplecrudroom.interfaces.daos.ProductDAO;
import com.tutoriales.simplecrudroom.interfaces.daos.SchoolDAO;

@Database(  entities = { Person.class,
                        Address.class,
                        Product.class,
                        School.class,
                        Director.class,
                        Brand.class,
                        BrandWithProductCrossRef.class},
            version = 3)
public abstract class AppDataBase extends RoomDatabase {

    public static AppDataBase INSTANCE; //Patron singleton

    public abstract PersonDAO personDAO();
    public abstract AddressDAO addressDAO();
    public abstract SchoolDAO schoolDAO();
    public abstract ProductDAO productDAO();
    public abstract BrandDAO brandDAO();

    public static AppDataBase getInstance(Context context){

        if(INSTANCE==null){
            INSTANCE = Room.databaseBuilder(context, AppDataBase.class, "Person")
                    .allowMainThreadQueries() //no usar esto, salvo sea prueba, usar corutinas
                    .fallbackToDestructiveMigration() //para no usar migraciones
                    .build();
        }

        return INSTANCE;
    }
}
