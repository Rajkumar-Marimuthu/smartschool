package com.rojatech.smartschool.repository;

import com.rojatech.smartschool.domain.Book;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface BookRepository extends ReactiveMongoRepository<Book, String> {
}
