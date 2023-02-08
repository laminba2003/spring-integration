package com.spring.training.controller;


import com.spring.training.model.Email;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apis/email")
public class EmailController {

    @PostMapping
    public Email sendEmail(@RequestBody @Valid Email email) {
        return email;
    }

}
