package spring.ku.boot.dao.data;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class PageRepoTest extends JpaTestConfiguration{

    @Autowired
    private PageRepo pageRepo;

    @Test
    public void page(){
        System.out.println(String.format("count = %d", pageRepo.count()));
    }

}
