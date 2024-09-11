package ru.alyoshka.hibernatedao.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.alyoshka.hibernatedao.entity.Contact;
import ru.alyoshka.hibernatedao.entity.Person;

import java.util.List;

@Repository
public class PersonRepositoryImpl implements PersonRepository {
    @PersistenceContext
    private EntityManager entityManager;

    private final List<Person> people = List.of(
            Person.builder()
                    .contact(Contact.builder()
                            .name("Петя")
                            .surname("Петров")
                            .age(7)
                            .build())
                    .cityOfLiving("Moscow")
                    .phoneOfNumber("+79451221")
                    .build(),

            Person.builder().contact(Contact.builder()
                            .name("Вова")
                            .surname("Владимиров")
                            .age(8)
                            .build())
                    .cityOfLiving("SPb")
                    .phoneOfNumber("+78121221")
                    .build(),

            Person.builder().contact(Contact.builder()
                            .name("Мария")
                            .surname("Мурманчанка")
                            .age(9)
                            .build())
                    .cityOfLiving("Murmansk")
                    .phoneOfNumber("+7221221")
                    .build()
    );

    @Override
    @Transactional
    public void createTable() {
        for (Person person : people) entityManager.persist(person);
    }

    @Override
    @Transactional
    public List<Person> getPersonsByCity(String city) {
        String hql = "SELECT p FROM Person p WHERE LOWER(p.cityOfLiving) = LOWER(:city)";
        return entityManager.createQuery(hql)
                .setParameter("city", city)
                .getResultList();

    }
}
