package com.spring.training.messaging.http;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class HttpRunner implements CommandLineRunner {

    final HttpSender sender;

    @Override
    public void run(String... args) {
        sender.sendMessage("hello", "GET");
        sender.sendMessage("hello", "POST", "John Doe");
    }

}