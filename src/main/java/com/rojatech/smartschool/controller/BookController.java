package com.rojatech.smartschool.controller;

import com.rojatech.smartschool.domain.Book;
import com.rojatech.smartschool.event.BookEvent;
import com.rojatech.smartschool.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/book/{id}")
    public Mono<Book> getBookById(@PathVariable String id) {
        return bookService.getBookById(id);
    }

    @GetMapping("/book")
    public Flux<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping(value = "/event/{id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<BookEvent> streamBookEvent(@PathVariable String id) {
        return bookService.streamBookEvents(id);
    }
}
