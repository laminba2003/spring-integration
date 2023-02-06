package com.spring.training.config;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.integration.http.inbound.HttpRequestHandlingMessagingGateway;
import org.springframework.integration.http.outbound.HttpRequestExecutingMessageHandler;
import org.springframework.integration.http.support.DefaultHttpHeaderMapper;

public class BeanProcessor implements BeanPostProcessor {

    static final String[] ALLOWED_HTTP_REQUEST_HEADERS = {
            DefaultHttpHeaderMapper.HTTP_REQUEST_HEADER_NAME_PATTERN,
    };
    static final String[] ALLOWED_HTTP_RESPONSE_HEADERS = {
            DefaultHttpHeaderMapper.HTTP_RESPONSE_HEADER_NAME_PATTERN
    };

    public Object postProcessAfterInitialization(Object bean, String beanName) {
        return switch (bean) {
            case HttpRequestHandlingMessagingGateway handler -> {
                handler.setHeaderMapper(inboundMapper());
                yield handler;
            }
            case HttpRequestExecutingMessageHandler handler -> {
                handler.setHeaderMapper(outboundMapper());
                yield handler;
            }
            default -> bean;
        };
    }

    private DefaultHttpHeaderMapper inboundMapper() {
        DefaultHttpHeaderMapper mapper = DefaultHttpHeaderMapper.inboundMapper();
        mapper.setInboundHeaderNames(ALLOWED_HTTP_REQUEST_HEADERS);
        mapper.setUserDefinedHeaderPrefix("");
        mapper.setOutboundHeaderNames(ALLOWED_HTTP_RESPONSE_HEADERS);
        return mapper;
    }

    private DefaultHttpHeaderMapper outboundMapper() {
        DefaultHttpHeaderMapper mapper = DefaultHttpHeaderMapper.outboundMapper();
        mapper.setInboundHeaderNames(ALLOWED_HTTP_REQUEST_HEADERS);
        mapper.setUserDefinedHeaderPrefix("");
        mapper.setOutboundHeaderNames(ALLOWED_HTTP_RESPONSE_HEADERS);
        return mapper;
    }

}