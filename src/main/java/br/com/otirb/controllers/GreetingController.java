package br.com.otirb.controllers;

import br.com.otirb.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    // http://localhost:8080/greeting?name=Gabriel
    // http://localhost:8080/math/sum/3/5
    @RequestMapping("/greeting")
    public Greeting greeting(
            @RequestParam(value = "name", defaultValue = "World")
            String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
