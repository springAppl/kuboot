package spring.ku.boot.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import spring.ku.boot.KubootAppTest;
import spring.ku.boot.model.User;

public class UserDAOTest extends KubootAppTest {

    @Autowired
    private UserDAO userDAO;

    @Test
    public void users(){
        User user = userDAO.findByID(8L);
        System.out.println(user);
    }
}