package ru.alyoshka.hibernatedao.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.alyoshka.hibernatedao.entity.Person;
import ru.alyoshka.hibernatedao.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService service;

    @GetMapping("/create")
    public void createTable() {
        service.createTable();
    }

    @GetMapping("/by-city")
    public List<Person> getPersonByCity(@RequestParam(value = "city") String city) {
        return service.getPersonByCity(city);
    }
}
