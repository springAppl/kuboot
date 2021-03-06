package spring.ku.boot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/test")
@RestController
public class TestController {
    @Value("${envName}")
    private String name;

    @Value("${spring.datasource.url}")
    private String url;


    @GetMapping("/name")
    public String name(){
        return name;
    }

    @GetMapping("/url")
    public String url(){
        return url;
    }
}
