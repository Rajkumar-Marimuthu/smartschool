package com.rojatech.smartschool.repository;

import com.rojatech.smartschool.dto.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class PersonRepositoryImplTest {

    PersonRepository personRepository;

    @BeforeEach
    void setUp() {
        personRepository = new PersonRepositoryImpl();
    }

    @Test
    void getByIdBlock() {
        Mono<Person> personMono = personRepository.getById(1);
        Person person = personMono.block();
        assert person != null;
        assertEquals(1, person.getId());
    }

    @Test
    void getByIdSubscribe() {
        Mono<Person> personMono = personRepository.getById(1);
        StepVerifier.create(personMono).expectNextCount(1).verifyComplete();
        personMono.subscribe(person -> assertEquals(1, person.getId()));
    }

    @Test
    void getByIdNotFoundException() {
        final int id=8;
        Flux<Person> personFlux = personRepository.findAll();
        Mono<Person> personMono = personFlux.filter(person -> person.getId() == id).single();

        personMono.doOnError(e -> System.out.println(e.getMessage()))
                .onErrorReturn(Person.builder().id(id).firstName("FIRSTNAME").build())
                .subscribe(person -> System.out.println(person.getFirstName()));
    }

    @Test
    void getByIdEmpty() {
        final int id=5;
        Mono<Person> personMono = personRepository.getById(id);
        // This will not print, as personMon is empty.
        personMono.subscribe(person -> System.out.println(person.getFirstName()));
    }

    @Test
    void findAll() {
    }
}