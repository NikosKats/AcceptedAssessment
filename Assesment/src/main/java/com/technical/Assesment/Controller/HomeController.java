package com.technical.Assesment.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    String hello() {
        return "Hello World, Spring Boot!";
    }
}
