package com.rojatech.smartschool.repository;

import com.rojatech.smartschool.dto.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class PersonRepositoryImpl implements PersonRepository {

    Person winston = new Person(1, "Winston", "Churchil");
    Person michael = new Person(2, "Michael", "Williams");
    Person fiona = new Person(3, "Fiona", "William");
    Person harry = new Person(4, "Harry", "Potter");

    final List<Person> persons = List.of(winston, michael, fiona, harry);

    @Override
    public Mono<Person> getById(final int id) {
        return Mono.justOrEmpty(persons.stream().filter(person -> id == person.getId()).findFirst());
    }

    @Override
    public Flux<Person> findAll() {
        return Flux.just(winston, michael, fiona, harry);
    }
}
