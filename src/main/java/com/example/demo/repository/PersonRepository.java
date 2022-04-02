package com.example.demo.repository;

import com.example.demo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findAll();

    List<Person> findByCity(String city);

    List<Person> findByAgeLessThanOrderByAge(int age);

    List<Person> findByNameAndSurname(String name, String surname);
}