package spring.ku.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import spring.ku.boot.criteria.UserCriteria;
import spring.ku.boot.exception.WebException;
import spring.ku.boot.model.User;
import spring.ku.boot.service.UserReadService;
import spring.ku.boot.service.UserWriteService;
import spring.ku.boot.util.UserUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

@RequestMapping("/api/user")
@RestController
public class UserController {


    @Autowired
    private UserReadService userReadService;

    @Autowired
    private UserWriteService userWriteService;


    @GetMapping("/paging")
    public List<User> paging(){
        return userReadService.paging(new UserCriteria());
    }

    @GetMapping("/login")
    public User login(HttpServletRequest request,
                         @RequestParam("account") String account,
                         @RequestParam("password") String password){
        User query = new User();
        query.setName(account);
        User user = userReadService.findByUser(query);
        if (Objects.isNull(user)) {
            throw new WebException("ACCOUNT_NOT_EXIST", 400);
        }
        if (!Objects.equals(user.getPassword(), password)) {
            throw new WebException("PASSWORD_NOT_MATCH", 400);
        }
        loginActivity(user.getId(), request);
        return info(user.getId());
    }


    private void loginActivity(Long id, HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        session.setAttribute("id", id);
    }

    @GetMapping("/info")
    public User info(HttpServletRequest request){
        return info(UserUtil.current(request));
    }

    private User info(Long id) {
        return userReadService.findByID(id);
    }


    @PostMapping
    public User create(HttpServletRequest request, @RequestBody User user){
        //assert name
        if (Objects.isNull(user)) {
            throw new WebException("USER_NOT_NULL", 400);
        }
        if (StringUtils.isEmpty(user.getName())) {
            throw new WebException("USER_NAME_NOT_EMPTY", 400);
        }
        if (userReadService.exist(user)) {
            throw new WebException("ACCOUNT_HAS_EXIST");
        }
        Long id = userWriteService.create(user);
        loginActivity(id, request);
        return info(id);
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request){
        request.getSession().invalidate();
    }


    @GetMapping("/test")
    public User test(){
        User user = new User();
        user.setId(1L);
        return user;
    }

    @GetMapping("/error")
    public User error(){
        throw new WebException("error");
    }
}
