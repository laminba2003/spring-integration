package com.spring.training.config;

import com.spring.training.messaging.Transformer;
import com.spring.training.service.HelloService;
import com.spring.training.service.PrinterService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfig {

    @Bean
    public HelloService helloService() {
        return new HelloService();
    }

    @Bean
    public PrinterService printerService() {
        return new PrinterService();
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.additionalInterceptors((request, body, execution) -> {
            request.getHeaders().add("Authorization", "Bearer " + "token");
            return execution.execute(request, body);
        }).build();
    }

    @Bean
    public Transformer transformer() {
        return new Transformer();
    }

}
