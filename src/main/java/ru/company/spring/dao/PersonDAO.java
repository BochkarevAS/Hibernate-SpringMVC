package ru.company.spring.dao;

import ru.company.spring.entity.Person;

import java.util.List;

public interface PersonDAO {

    void createPerson(Person person);

    List<Person> readPerson();

    void updatePerson(Person person);

    void deletePerson(int id);

    Person getPersonById(int id);
}
