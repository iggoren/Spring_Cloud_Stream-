package com.example.storebookservice.service;


import com.example.storebookservice.entity.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@EnableBinding(Sink.class)
public class StoreBookService {


    @StreamListener(Sink.INPUT)
    public void storeBook(Message<Book> bookMessage) {

        log.info("received book {}", bookMessage.getPayload());
    }

}
