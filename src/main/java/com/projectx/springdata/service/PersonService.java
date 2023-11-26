package com.projectx.springdata.service;

import com.projectx.springdata.model.Person;
import com.projectx.springdata.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonService {

    PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void save() {
        Person person = new Person();
        person.setName("John Luther");
        person.setAge(35);
        person.setGender("Male");
        personRepository.save(person);
    }
}
