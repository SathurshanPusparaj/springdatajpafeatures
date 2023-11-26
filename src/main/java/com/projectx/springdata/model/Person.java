package com.projectx.springdata.model;

import com.projectx.springdata.validator.Email;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Person extends BaseEntity<Long> {

    private String name;

    private Integer age;

    private String gender;

    @Email
    private String email;
}
