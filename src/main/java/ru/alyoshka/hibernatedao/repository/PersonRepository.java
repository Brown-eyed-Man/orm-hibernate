package ru.alyoshka.hibernatedao.repository;

import ru.alyoshka.hibernatedao.entity.Person;

import java.util.List;

public interface PersonRepository {
    void createTable();

    List<Person> getPersonsByCity(String city);
}
