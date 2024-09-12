package ru.alyoshka.hibernatedao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alyoshka.hibernatedao.entity.Person;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    List<Person> findByCityOfLivingIgnoreCase(String city);

    List<Person> findByContactAgeLessThanOrderByContactAgeAsc(int age);

    List<Person> findByContactNameAndContactSurname(String name, String surname);
}
