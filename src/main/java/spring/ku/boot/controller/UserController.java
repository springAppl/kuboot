package spring.ku.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.ku.boot.criteria.UserCriteria;
import spring.ku.boot.model.User;
import spring.ku.boot.service.UserReadService;

import java.util.List;

@RequestMapping("/api/user")
@RestController
public class UserController {


    @Autowired
    private UserReadService userReadService;


    @GetMapping("/paging")
    public List<User> paging(){
        return userReadService.paging(new UserCriteria());
    }

    @GetMapping("/login")
    public Boolean login(@RequestParam("account") String account,
                         @RequestParam("password") String password){
        User user = new User();
        user.setName(account);
        user.setPassword(password);
        return userReadService.login(user);
    }
}
