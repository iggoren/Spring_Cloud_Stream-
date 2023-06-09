package com.example.creationbookservice.config;

import com.example.creationbookservice.entity.Book;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageChannel;

import java.util.LinkedList;

@Configuration
public class ConfigEventSource {
    @Bean("book-event-source")
    public LinkedList<Book> createBookCreationEventSource(){

        return new LinkedList<>();
    }
    @Bean("bookEventProcessor-out-0")
    public MessageChannel bookEventProcessorOut() {
        return new DirectChannel();
    }


}
