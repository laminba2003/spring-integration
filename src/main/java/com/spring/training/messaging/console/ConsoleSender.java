package com.spring.training.messaging.console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

@Service
public class ConsoleSender {

    @Autowired
    @Qualifier("inputChannel")
    MessageChannel channel;

    public void sendMessage(String content) {
        Message<String> message = MessageBuilder.withPayload(content).build();
        channel.send(message);
    }

}
