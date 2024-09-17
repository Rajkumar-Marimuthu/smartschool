package com.rojatech.smartschool.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
    private String id;
    @NonNull
    private String title;
}
