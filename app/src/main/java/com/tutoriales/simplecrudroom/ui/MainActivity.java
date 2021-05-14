package com.tutoriales.simplecrudroom.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.tutoriales.simplecrudroom.R;
import com.tutoriales.simplecrudroom.entities.Address;
import com.tutoriales.simplecrudroom.entities.Person;
import com.tutoriales.simplecrudroom.entities.relations.PersonWithAddresses;
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
            //getAllPersons();
            //getPersonById(2);
            //insertPerson();
            //insertAllPersons();
            //updatePerson(1);
            //deletePerson(3);
            //insertPersonWithAddress();
            getAllPersonsWithAddress();
        }catch (Exception ex){
            tvResult.setText(ex.getMessage());
        }
    }

    //One to many relation and methods person - address
    private void getAllPersons(){
        List<Person> list = personService.getAll();
        tvResult.setText(list.toString());
    }

    private void getPersonById(int id){
        Person person = personService.getById(id);
        tvResult.setText(person.toString());
    }

    private void insertAllPersons() {
        List<Person> list = new ArrayList<>();
        Person person = null;
        int randomNumber = (int) (Math.random() * 50);

        person = new Person();
        person.setName("User " + randomNumber);
        person.setAge(randomNumber);
        person.setActive(true);
        list.add(person);

        person = new Person();
        person.setName("User " + randomNumber);
        person.setAge(randomNumber);
        person.setActive(true);
        list.add(person);

        personService.insertAll(list);

        list = personService.getAll();
        tvResult.setText(list.toString());
    }

    private void insertPerson(){
        List<Person> list = new ArrayList<>();
        Person person = null;
        int randomNumber = (int) (Math.random() * 50);

        person = new Person();
        person.setName("User " + randomNumber);
        person.setAge((int) (Math.random() * 50));
        person.setActive(true);

        personService.insert(person);

        list = personService.getAll();
        tvResult.setText(list.toString());
    }

    private void updatePerson(int id){
        List<Person> list = new ArrayList<>();
        Person person = null;
        int randomNumber = (int) (Math.random() * 50);

        person = personService.getById(id);
        person.setName("User " + randomNumber);
        person.setAge(randomNumber);
        person.setActive(false);

        personService.update(person);

        list = personService.getAll();
        tvResult.setText(list.toString());
    }

    private void deletePerson(int id){
        List<Person> list = new ArrayList<>();
        Person person = personService.getById(id);
        personService.delete(person);

        list = personService.getAll();
        tvResult.setText(list.toString());
    }

    private void insertPersonWithAddress(){
        List<Person> list = new ArrayList<>();
        Person person = null;
        List<Address> addressList = new ArrayList<>();
        Address address;
        PersonWithAddresses personWithAddresses = new PersonWithAddresses();
        int randomNumber = (int) (Math.random() * 50);
        long result=0;

        person = new Person();
        person.setName("User " + randomNumber);
        person.setAge(randomNumber);
        person.setActive(true);

        address = new Address();
        address.setStreet("street " + randomNumber);
        address.setCity("city " + randomNumber);
        address.setState("state " + randomNumber);
        addressList.add(address);

        personWithAddresses.setPerson(person);
        personWithAddresses.setAddressList(addressList);

        result= personService.insertPersonWithAddress(personWithAddresses);

        Toast.makeText(this,"result: " + result,Toast.LENGTH_SHORT).show();

        list = personService.getAll();
        tvResult.setText(list.toString());
    }

    private void getAllPersonsWithAddress(){
        List<PersonWithAddresses> list = personService.getPersonWithAddresses();
        tvResult.setText(list.toString());
    }
}