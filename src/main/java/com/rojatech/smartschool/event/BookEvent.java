package com.rojatech.smartschool.event;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class BookEvent {
    private String bookId;
    private Date publishedOn;
}
