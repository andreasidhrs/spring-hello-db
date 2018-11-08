package com.realsprint.academy.hellodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PeopleRepository peopleRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    private List<Person> getPeople() {
        return peopleRepository.findAll();
    }

    @GetMapping("/person/add/{username}/{age}")
    private List<Person> addPerson(@PathVariable String username, @PathVariable int age) {
        Person person = new Person();
        person.setName(username);
        person.setAge(age);
        peopleRepository.save(person);
        return peopleRepository.findAll();
    }

    @GetMapping("/jdbc")
    private List<User> getUsers() {
        return userRepository.getUsers();
    }
}
