package com.egorbarinov.demorepository.controller;

import com.egorbarinov.demorepository.entity.Person;
import com.egorbarinov.demorepository.repository.PersonRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    private final PersonRepository<Person> repository = new PersonRepository<>(Person.class);

    @GetMapping("/findById/{id}")
    @ResponseBody
    public Person findById(@PathVariable("id") String id) {

        return repository.findById(Person.class, Integer.valueOf(id));
    }

    // метод repository.save(person) не отрабатывает. выдает безсконечный java.lang.StackOverflowError: null. не могу понять, почему??
    @GetMapping("/initPerson")  //java.lang.StackOverflowError: null
    @ResponseBody
    public Person initPerson() {

        Person person = new Person(null, "Egor", 38);
        repository.save(person);

        return person;
    }


    @GetMapping("/deletePerson/{id}") // Person(id=3, name=Monetochka, age=20) removed
    @ResponseBody
    public String deletePerson(@PathVariable("id") String id) {
        Person person = findById(id);
        repository.delete(person);
        return person + " removed";

    }

    @GetMapping("/getAll")
    @ResponseBody
    public List<Person> getAll() {
        return repository.findAll();
    }


}
