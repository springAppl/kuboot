package spring.ku.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.authentication.session.NullAuthenticatedSessionStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import spring.ku.boot.criteria.SimplePage;
import spring.ku.boot.criteria.UserCriteria;
import spring.ku.boot.exception.WebException;
import spring.ku.boot.model.User;
import spring.ku.boot.service.UserReadService;
import spring.ku.boot.service.UserWriteService;
import spring.ku.boot.util.UserUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@RequestMapping("/api/user")
@RestController
public class UserController {

    private final UserReadService userReadService;

    private final UserWriteService userWriteService;

    private final AuthenticationManager authenticationManager;

    private final LogoutHandler logoutHandler;

    @Autowired
    public UserController(UserReadService userReadService,
                          UserWriteService userWriteService,
                          AuthenticationManager authenticationManager) {
        this.userReadService = userReadService;
        this.userWriteService = userWriteService;
        this.authenticationManager = authenticationManager;
        this.logoutHandler = new SecurityContextLogoutHandler();
    }

    @GetMapping("/paging")
    public SimplePage<User> paging(Integer pageNo, Integer pageSize){
        return userReadService.paging(new UserCriteria(pageNo, pageSize));
    }

    @PostMapping("/login")
    public User login(HttpServletRequest request,
                      @RequestParam("account") String account,
                      @RequestParam("password") String password,
                      HttpServletResponse response){
        User query = new User();
        query.setName(account);

        User result = userReadService.findByUser(query);
        if (Objects.isNull(result)) {
            throw new WebException("用户不存在");
        }
        if (!Objects.equals(result.getPassword(), password)) {
            throw new WebException("用户名密码不匹配");
        }
        loginActivity(result, request, response);
        return info(UserUtil.current().getId());
    }


    private void loginActivity(User user, HttpServletRequest request, HttpServletResponse response) {
        Authentication authRequest = new UsernamePasswordAuthenticationToken(user, null);

        //Authentication authentication = authenticationManager.authenticate(authRequest);
        SecurityContextHolder.getContext().setAuthentication(authRequest);
        SessionAuthenticationStrategy sessionStrategy = new NullAuthenticatedSessionStrategy();
        sessionStrategy.onAuthentication(authRequest, request, response);
    }

    @GetMapping
    public User info(){
        return info(UserUtil.current().getId());
    }

    private User info(Long id) {
        User user = userReadService.findByID(id);
        if (Objects.isNull(user)) {
            throw new WebException("用户不存在");
        }
        return cleanPassword(user);
    }


    @PostMapping
    public User create(HttpServletRequest request,
                       HttpServletResponse response,
                       @RequestBody User user){
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
        User result = userReadService.findByID(id);
        if (Objects.isNull(result)) {
            throw new WebException("系统异常");
        }
        loginActivity(result, request, response);
        return info(id);
    }

    @PutMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        this.logoutHandler.logout(request, response, auth);
    }

    private User cleanPassword(User user){
        user.setPassword(null);
        return user;
    }
}