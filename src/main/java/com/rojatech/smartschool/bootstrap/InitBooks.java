package com.rojatech.smartschool.bootstrap;

import com.rojatech.smartschool.domain.Book;
import com.rojatech.smartschool.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class InitBooks implements CommandLineRunner {

    private final BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        bookRepository.deleteAll()
                .thenMany(Flux.just("Data Engineering", "Machine Learning", "Artificial Intelligence",
                                "Spring", "Python", "Go", "Kafka")
                        .map(title -> Book.builder().title(title).build())
                        .flatMap(bookRepository::save))
                .subscribe(null, null, () -> {
                            bookRepository.findAll().subscribe(System.out::println);});
    }
}
