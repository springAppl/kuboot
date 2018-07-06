package spring.ku.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/test")
@RestController
public class TestController {
//    @Autowired
//    private LoginUrlAuthenticationEntryPoint loginUrlAuthenticationEntryPoint;

    @GetMapping("/haha")
    public String test(){
        return "good";
    }
}
