package com.spring.training.messaging.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

@Service
public class HttpSender {

    @Autowired
    @Qualifier("localHttpChannel")
    MessageChannel httpChannel;

    public void sendMessage(String path, String method, String... content) {
        String payload = content.length > 0 ? content[0] : "";
        Message<String> message = MessageBuilder.withPayload(payload)
                .setHeader("path", path)
                .setHeader("http_requestMethod", method).build();
        httpChannel.send(message);
    }

}
