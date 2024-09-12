package ru.alyoshka.hibernatedao.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.alyoshka.hibernatedao.entity.Person;
import ru.alyoshka.hibernatedao.repository.PersonRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {
    public final PersonRepository personRepository;


    public List<Person> findByCity(String city) {
        return personRepository.findByCityOfLivingIgnoreCase(city);
    }

    public List<Person> findByAgeLessThanOrderByAgeAsc(int age) {
        return personRepository.findByContactAgeLessThanOrderByContactAgeAsc(age);
    }

    public List<Person> findByNameAndSurname(String name, String surname) {
        return personRepository.findByContactNameAndContactSurname(name, surname);
    }
}
