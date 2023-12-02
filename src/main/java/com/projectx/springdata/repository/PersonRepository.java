package com.projectx.springdata.repository;

import com.projectx.springdata.model.Person;
import com.projectx.springdata.repository.queryrewriter.CustomQueryRewriter;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends BatchRepository<Person, Long> {

    @Query(nativeQuery = true, value = "select * from person where age = ?1")
    List<Person> findByAge(int age);

    @Modifying
    @Query("insert into Person (name, age, gender) values (?1, ?2, ?3)")
    List<Person> insert(String name, Integer age, String gender);


    @Query(nativeQuery = true, value = "select * from person_table where name = ?1", queryRewriter = CustomQueryRewriter.class)
    List<Person> findByName(int age);

    @Query(value = "select p from #{#entityName} p where p.name = ?1")
    List<Person> findByName_CustomEntity(int age);
}
