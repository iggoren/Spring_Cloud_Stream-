package com.example.creationbookservice.service;

import com.example.creationbookservice.entity.Book;
import com.example.creationbookservice.util.BookGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
@Slf4j
@EnableBinding(Source.class)
public class CreationBookService {

    private final LinkedList<Book> bookCreationEvents;

    private final BookGenerator bookGenerator;

    public CreationBookService(LinkedList<Book> bookCreationEvents, BookGenerator bookGenerator) {
        this.bookCreationEvents = bookCreationEvents;


        this.bookGenerator = bookGenerator;
    }


    @Scheduled(fixedDelay = 10000)
    public void sendMessage() {
        Book book = bookGenerator.createNewBook();
        bookCreationEvents.add(book);
        // System.out.println("книга создана" + book.getName());
    }
}

