package com.example.checkbookservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;

@SpringBootApplication
@EnableBinding(Sink.class)
public class CheckBookServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CheckBookServiceApplication.class, args);
    }
}
