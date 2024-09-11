package ru.alyoshka.hibernatedao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @EmbeddedId
    private Contact contact;
    @Column
    private String phoneOfNumber;
    @Column
    private String cityOfLiving;
}
