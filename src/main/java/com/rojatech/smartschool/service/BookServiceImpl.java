package com.rojatech.smartschool.service;

import com.rojatech.smartschool.domain.Book;
import com.rojatech.smartschool.event.BookEvent;
import com.rojatech.smartschool.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Mono<Book> getBookById(String id) {
        return bookRepository.findById(id);
    }

    @Override
    public Flux<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Flux<BookEvent> streamBookEvents(String id) {
        return Flux.<BookEvent>generate(bookEventSynchronousSink -> {
            bookEventSynchronousSink.next(new BookEvent(id, new Date()));
        }).delayElements(Duration.ofSeconds(1));
    }
}
