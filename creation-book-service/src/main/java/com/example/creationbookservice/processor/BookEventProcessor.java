package com.example.creationbookservice.processor;

import com.example.creationbookservice.entity.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.function.Supplier;

@Component
@Slf4j
@EnableBinding(Source.class)
public class BookEventProcessor implements Supplier<Message<Book>> {

    private final LinkedList<Book> bookCreationEventSource;
    private final MessageChannel outputChannel;

    public BookEventProcessor(@Qualifier("book-event-source") LinkedList<Book> bookCreationEventSource,
                              @Qualifier("bookEventProcessor-out-0") MessageChannel outputChannel) {
        this.bookCreationEventSource = bookCreationEventSource;
        this.outputChannel = outputChannel;
    }

    @Override
    public Message<Book> get() {

        if (bookCreationEventSource.peek() != null) {
            log.info("sending new book {}", bookCreationEventSource.peek());

            return MessageBuilder.withPayload(bookCreationEventSource.poll())
                    .build();
        }
        return null;
    }

    public void sendMessage(Book book) {
        outputChannel.send(MessageBuilder.withPayload(book).build());
    }

}
