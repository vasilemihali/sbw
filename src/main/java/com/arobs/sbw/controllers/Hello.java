package com.arobs.sbw.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vasile.mihali
 * @since 8/5/2020
 */
@RestController
public class Hello {

    @RequestMapping(value = "/", produces = {"application/json"})
    public String index() {
        return "{\"title\":\"Greetings from Spring Boot AROBS!\"}";
    }
}
