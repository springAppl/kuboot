package spring.ku.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.ku.boot.model.User;
import spring.ku.boot.service.UserReadService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private UserReadService userReadService;


    @Autowired
    private AuthenticationManager authenticationManager;


    @RequestMapping("/detail/{id}")
    public User detail(@PathVariable Long id) {
        id = id + 1;
        return userReadService.findByID(id);
    }
}
