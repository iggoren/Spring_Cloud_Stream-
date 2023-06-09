package com.example.creationbookservice;

import com.example.creationbookservice.processor.BookEventProcessor;
import com.example.creationbookservice.service.CreationBookService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableBinding(Source.class)
@EnableScheduling
public class CreationBookServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CreationBookServiceApplication.class, args);

    }
}
