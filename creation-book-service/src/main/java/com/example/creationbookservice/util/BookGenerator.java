package com.example.creationbookservice.util;

import com.example.creationbookservice.entity.Book;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class BookGenerator {
    private final Random random = new Random();
    public Book createNewBook(){
        int randomBookId = random.nextInt(10);
        String randomName = "Book"+ randomBookId;
        String randomDecsription = "Book description" + randomBookId;
        String status = "unchecked";
        int price = randomBookId++;
        return Book.builder()
                .id(randomBookId)
                .name(randomName)
                .description(randomDecsription)
                .status(status)
                .price(price)
                .build();

    }


}
