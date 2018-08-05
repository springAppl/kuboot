package spring.ku.boot.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import spring.ku.boot.service.ArticleReadService;
import spring.ku.boot.service.ArticleWriteService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ArticleController.class)
public class ArticleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ArticleWriteService articleWriteService;

    @MockBean
    private ArticleReadService articleReadService;

    @Test
    public void contextLoads() throws Exception {
        String stringValue = mockMvc.perform(get("/api/article/2"))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
    }
}
