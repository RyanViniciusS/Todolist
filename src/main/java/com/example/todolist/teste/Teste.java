package com.example.todolist.teste;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Teste {
    @GetMapping("Hello")
    public String hello(@RequestBody String body) {
        return "hello world" + body;
    }
}
