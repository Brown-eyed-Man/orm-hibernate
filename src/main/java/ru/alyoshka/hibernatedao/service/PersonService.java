package ru.alyoshka.hibernatedao.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.alyoshka.hibernatedao.entity.Person;
import ru.alyoshka.hibernatedao.repository.PersonRepositoryImpl;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {
    public final PersonRepositoryImpl personRepository;

    public void createTable() {
        personRepository.createTable();
    }

    public List<Person> getPersonByCity(String city) {
        return personRepository.getPersonsByCity(city);
    }
}
