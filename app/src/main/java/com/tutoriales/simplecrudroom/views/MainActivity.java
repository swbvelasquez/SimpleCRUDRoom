package com.tutoriales.simplecrudroom.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.tutoriales.simplecrudroom.R;
import com.tutoriales.simplecrudroom.database.AppDataBase;
import com.tutoriales.simplecrudroom.entities.Person;
import com.tutoriales.simplecrudroom.interfaces.daos.PersonDAO;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try{
            tvResult = findViewById(R.id.tvResult);
            AppDataBase appDataBase = AppDataBase.getInstance(getApplicationContext());
            PersonDAO personDAO = appDataBase.personDAO();

            //getAll(personDAO);
            //getById(2,personDAO);
            //insert(personDAO);
            insertAll(personDAO);
            //update(1,personDAO);
            //delete(3,personDAO);
        }catch (Exception ex){
            tvResult.setText(ex.getMessage());
        }
    }

    private void getAll(PersonDAO personDAO){
        List<Person> list = personDAO.getAll();
        tvResult.setText(list.toString());
    }

    private void getById(int id,PersonDAO personDAO){
        Person person = personDAO.getById(id);
        tvResult.setText(person.toString());
    }

    private void insertAll(PersonDAO personDAO) {
        List<Person> list = new ArrayList<>();
        Person person = null;

        person = new Person();
        person.setName("User " + (int) (Math.random() * 50));
        person.setAge((int) (Math.random() * 50));
        person.setActive(true);
        list.add(person);

        person = new Person();
        person.setName("User " + (int) (Math.random() * 50));
        person.setAge((int) (Math.random() * 50));
        person.setActive(true);
        list.add(person);

        personDAO.insertAll(list);

        list = personDAO.getAll();
        tvResult.setText(list.toString());
    }

    private void insert(PersonDAO personDAO){
        List<Person> list = new ArrayList<>();
        Person person = null;

        person = new Person();
        person.setName("User " + (int) (Math.random() * 50));
        person.setAge((int) (Math.random() * 50));
        person.setActive(true);

        personDAO.insert(person);

        list = personDAO.getAll();
        tvResult.setText(list.toString());
    }

    private void update(int id,PersonDAO personDAO){
        List<Person> list = new ArrayList<>();
        Person person = null;

        person = personDAO.getById(id);
        person.setName("User " + (int) (Math.random() * 50));
        person.setAge((int) (Math.random() * 50));
        person.setActive(false);

        personDAO.update(person);

        list = personDAO.getAll();
        tvResult.setText(list.toString());
    }

    private void delete(int id,PersonDAO personDAO){
        List<Person> list = new ArrayList<>();
        Person person = personDAO.getById(id);
        personDAO.delete(person);

        list = personDAO.getAll();
        tvResult.setText(list.toString());
    }
}