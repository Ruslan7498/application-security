package com.example.demo.controller;

import com.example.demo.entity.Person;
import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {
    private final DemoService service;

    @Autowired
    public DemoController(DemoService service) {
        this.service = service;
    }

    @GetMapping("/persons")
    public String getMainPage() {
        return service.getMainPage();
    }

    @GetMapping("/persons/all")
    public List<Person> getPersonAll() {
        return service.getAllPerson();
    }

    @GetMapping("/persons/by-city")
    public List<Person> getPersonsByCity(@RequestParam(required = false) String city) {
        return service.getPersonsByCity(city);
    }

    @GetMapping("/persons/by-age-less")
    public List<Person> getPersonsByAgeLessThan(@RequestParam(required = false) int age) {
        return service.getPersonsByAgeLessThan(age);
    }

    @GetMapping("/persons/by-name-surname")
    public List<Person> ggetPersonsByNameAndSurname(@RequestParam(required = false) String name, String surname) {
        return service.getPersonsByNameAndSurname(name, surname);
    }
}