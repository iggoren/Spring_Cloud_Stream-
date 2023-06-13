package com.example.checkbookservice.service;

import com.example.checkbookservice.entity.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(Processor.class)
@MessageEndpoint
@Slf4j
public class CheckBookService {


    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public Message<Book> handleMessage(Message<Book> message) {
        Book book = message.getPayload();
        book.setStatus("checked");

        // Возвращение модели с измененным статусом
        Message<Book> updatedMessage = MessageBuilder.withPayload(book).copyHeaders(message.getHeaders()).build();
        log.info("Получена книга {}, {}", book.getName(), book.getStatus());
        return updatedMessage;
    }
}

