package spring.ku.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("/api/hello")
public class HelloController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping
    public String hello(){
        return messageSource.getMessage("name", null, Locale.CHINESE);
    }
}
