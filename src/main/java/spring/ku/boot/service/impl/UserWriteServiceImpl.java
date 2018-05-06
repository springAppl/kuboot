package spring.ku.boot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.ku.boot.dao.UserDAO;
import spring.ku.boot.model.User;
import spring.ku.boot.service.UserWriteService;

@Service
public class UserWriteServiceImpl implements UserWriteService {


    private final UserDAO userDAO;


    @Autowired
    public UserWriteServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @Override
    public Long create(User user) {
        userDAO.create(user);
        return user.getId();
    }
}
