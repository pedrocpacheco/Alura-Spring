package com.pcp.alurapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
    
    @GetMapping
    public String olaMundo(){
        return "Hello, Henry";
    }

}

/*
 * 1- Rest Controller
 * 2- Request Mapping ("/caminho")
 * 3- GetMapping -> Mostrando
 */
