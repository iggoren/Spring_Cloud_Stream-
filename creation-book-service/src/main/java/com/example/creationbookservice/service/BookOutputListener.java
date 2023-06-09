//package com.example.creationbookservice.service;
//
//import com.example.creationbookservice.entity.Book;
//import org.springframework.cloud.stream.annotation.StreamListener;
//import org.springframework.stereotype.Component;
//
//@Component
//public class BookOutputListener {
//
//    @StreamListener("bookOutput")
//    public void receiveBookMessage(Book book) {
//        // Обработка полученного сообщения с книгой
//        System.out.println("Received book: " + book.getName());
//    }
//}
