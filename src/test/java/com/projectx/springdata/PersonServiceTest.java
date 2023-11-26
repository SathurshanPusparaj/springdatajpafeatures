package com.projectx.springdata;

import com.projectx.springdata.model.Person;
import com.projectx.springdata.repository.BatchRepository;
import com.projectx.springdata.repository.PersonRepository;
import com.projectx.springdata.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@DataJpaTest
@ComponentScan(value = "com.projectx.springdata.*")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PersonServiceTest {

    @Autowired
    PersonService personService;

    @Autowired
    PersonRepository personRepository;

    @Test
    @Rollback(false)
    public void save() {
        personService.save();
    }

    @Test
    @Rollback(value = false)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void testBatchPerson() {

        List<Person> persons = new ArrayList<>(150);
        
        for (int i=0; i<150; i++) {
            Person person = new Person();
            person.setName("Andy" + i);
            person.setGender("Male" + i);
            person.setAge(25);
            persons.add(person);
        }
        personRepository.saveInBatch(persons);
    }
}
