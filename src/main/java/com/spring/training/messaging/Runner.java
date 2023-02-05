package com.spring.training.messaging;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Runner implements CommandLineRunner {

    final Sender sender;

    @Override
    public void run(String... args) {
        sender.sendMessage("John Doe");
        sender.sendHttpMessage("hello", "GET");
        sender.sendHttpMessage("hello", "POST", "John Doe");
    }

}