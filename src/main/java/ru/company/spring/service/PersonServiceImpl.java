package ru.company.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.company.spring.dao.PersonDAO;
import ru.company.spring.entity.Person;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDAO dataSource;

    @Transactional
    @Override
    public void addPerson(Person person) {
        dataSource.createPerson(person);
    }

    @Transactional
    @Override
    public void updatePerson(Person person) {
        dataSource.updatePerson(person);
    }

    @Transactional
    @Override
    public List<Person> readPerson() {
        List<Person> persons = dataSource.readPerson();
        return persons;
    }

    @Transactional
    @Override
    public Person getPersonById(int id) {
        return dataSource.getPersonById(id);
    }

    @Transactional
    @Override
    public void deletePerson(int id) {
        dataSource.deletePerson(id);
    }
}
