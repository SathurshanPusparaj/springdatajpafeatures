package com.projectx.springdata;

import com.projectx.springdata.service.PersonService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/persons")
    public void savePerson(HttpServletRequest request) {
        request.getUserPrincipal();
        personService.save();
    }
}
