package com.spring.training.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

@Service
public class Sender {

    @Autowired
    @Qualifier("inputChannel")
    MessageChannel channel;
    @Autowired
    @Qualifier("httpChannel")
    MessageChannel httpChannel;

    public void sendMessage(String content) {
        Message<String> message = MessageBuilder.withPayload(content).build();
        channel.send(message);
    }

    public void sendHttpMessage(String path, String method, String... content) {
        String payload = content.length > 0 ? content[0] : "";
        Message<String> message = MessageBuilder.withPayload(payload)
                .setHeader("path", path)
                .setHeader("httpMethod", method).build();
        httpChannel.send(message);
    }

}
