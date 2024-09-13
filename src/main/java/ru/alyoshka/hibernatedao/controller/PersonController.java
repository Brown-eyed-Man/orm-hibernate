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

    //  ИЗНАЧАЛЬНО ЗАПУСТИТЬ schema.sql ИЗ ПАПКИ resources для создания таблицы с данными.
    //  http://localhost:8080/persons/find-by-city?city=Москва
    @GetMapping("/find-by-city")
    public List<Person> findByCity(@RequestParam("city") String city) {
        return service.findByCity(city);
    }

    //  http://localhost:8080/persons/find-by-name-and-surname?name=Алексей&surname=Копатыч
    @GetMapping("/find-by-name-and-surname")
    public List<Person> findByNameAndSurname(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return service.findByNameAndSurname(name, surname);
    }

    //  http://localhost:8080/persons/by-age-less?age=17
    @GetMapping("/by-age-less")
    public List<Person> findByAgeAndOrder (@RequestParam(value = "age") int age) {
        return service.findByAgeLessThanOrderByAgeAsc(age);
    }

    @GetMapping("hello")
    public String hello() {
        return "Hello :)";
    }
}
