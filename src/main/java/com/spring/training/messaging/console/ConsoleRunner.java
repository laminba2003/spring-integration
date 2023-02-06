package com.spring.training.messaging.console;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ConsoleRunner implements CommandLineRunner {

    final ConsoleSender sender;

    @Override
    public void run(String... args) {
        sender.sendMessage("John Doe");
    }

}