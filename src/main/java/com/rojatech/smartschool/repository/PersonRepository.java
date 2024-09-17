package com.rojatech.smartschool.repository;

import com.rojatech.smartschool.dto.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonRepository {
    Mono<Person> getById(int id);
    Flux<Person> findAll();
}
