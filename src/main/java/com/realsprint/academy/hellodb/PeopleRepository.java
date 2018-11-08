package com.realsprint.academy.hellodb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Long> {
    //List<Person> findByEmailAddressAndLastname(EmailAddress emailAddress, String lastname);
    //List<Person> findByLastnameIgnoreCase(String lastname);
    public Person findByName(String name);
}
