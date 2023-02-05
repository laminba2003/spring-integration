package com.spring.training.controller;

import com.spring.training.service.HelloService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
@AllArgsConstructor
public class HelloController {
    final HelloService helloService;

    @PostMapping
    public String sayHello(@RequestBody String name)  {
        return helloService.sayHello(name);
    }

    @GetMapping
    public String welcome() {
        return helloService.welcome();
    }

}
