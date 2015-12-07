package ru.company.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.company.spring.entity.Person;
import ru.company.spring.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Person> getAllPersons() {
        return personService.readPerson();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Person getPersonById(@PathVariable int id) {
        return personService.getPersonById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public List<Person> deletePersons(@PathVariable int id) {
        personService.deletePerson(id);
        return personService.readPerson();
    }

    @RequestMapping(value = "/{id}/{name}/{status}/{sex}", method = RequestMethod.PUT)
    public List<Person> updatePersons(@PathVariable int id, @PathVariable String name, @PathVariable String status, @PathVariable String sex) {
        Person person = new Person();
        person.setId(id);
        person.setName(name);
        person.setStatus(status);
        person.setSex(sex);

        personService.updatePerson(person);
        return personService.readPerson();
    }

    @RequestMapping(value = "/{name}/{status}/{sex}", method = RequestMethod.POST)
    public List<Person> setAllPersons(@PathVariable String name, @PathVariable String status, @PathVariable String sex) {
        Person person = new Person();
        person.setName(name);
        person.setStatus(status);
        person.setSex(sex);

        personService.addPerson(person);
        return personService.readPerson();
    }

}
