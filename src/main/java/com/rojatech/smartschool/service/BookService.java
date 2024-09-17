package com.rojatech.smartschool.service;

import com.rojatech.smartschool.domain.Book;
import com.rojatech.smartschool.event.BookEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookService {
    Mono<Book> getBookById(String id);
    Flux<Book> getAllBooks();
    Flux<BookEvent> streamBookEvents(String id);
}
