package com.tutoriales.simplecrudroom.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.tutoriales.simplecrudroom.R;
import com.tutoriales.simplecrudroom.database.AppDataBase;
import com.tutoriales.simplecrudroom.entities.Person;
import com.tutoriales.simplecrudroom.interfaces.daos.PersonDAO;
import com.tutoriales.simplecrudroom.interfaces.services.IPersonService;
import com.tutoriales.simplecrudroom.services.PersonService;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult;
    private IPersonService personService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try{
            tvResult = findViewById(R.id.tvResult);

            personService = PersonService.getInstance(getApplicationContext());
            //getAll();
            //getById(2);
            //insert();
            insertAll();
            //update(1);
            //delete(3);
        }catch (Exception ex){
            tvResult.setText(ex.getMessage());
        }
    }

    private void getAll(){
        List<Person> list = personService.getAll();
        tvResult.setText(list.toString());
    }

    private void getById(int id){
        Person person = personService.getById(id);
        tvResult.setText(person.toString());
    }

    private void insertAll() {
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

        personService.insertAll(list);

        list = personService.getAll();
        tvResult.setText(list.toString());
    }

    private void insert(){
        List<Person> list = new ArrayList<>();
        Person person = null;

        person = new Person();
        person.setName("User " + (int) (Math.random() * 50));
        person.setAge((int) (Math.random() * 50));
        person.setActive(true);

        personService.insert(person);

        list = personService.getAll();
        tvResult.setText(list.toString());
    }

    private void update(int id){
        List<Person> list = new ArrayList<>();
        Person person = null;

        person = personService.getById(id);
        person.setName("User " + (int) (Math.random() * 50));
        person.setAge((int) (Math.random() * 50));
        person.setActive(false);

        personService.update(person);

        list = personService.getAll();
        tvResult.setText(list.toString());
    }

    private void delete(int id){
        List<Person> list = new ArrayList<>();
        Person person = personService.getById(id);
        personService.delete(person);

        list = personService.getAll();
        tvResult.setText(list.toString());
    }
}