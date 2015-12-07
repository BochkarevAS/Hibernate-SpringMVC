package ru.company.spring.service;

import ru.company.spring.entity.Person;

import java.util.List;

public interface PersonService {

    void addPerson(Person person);

    void updatePerson(Person person);

    List<Person> readPerson();

    Person getPersonById(int id);

    void deletePerson(int id);
}
