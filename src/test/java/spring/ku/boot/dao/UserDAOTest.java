package spring.ku.boot.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import spring.ku.boot.model.User;
@RunWith(SpringRunner.class)
@MybatisTest
@Import(UserDAO.class)
public class UserDAOTest {

    @Autowired
    private UserDAO userDAO;

    @Test
    public void users(){
        User user = userDAO.findByID(8L);
        System.out.println(user);
    }
}