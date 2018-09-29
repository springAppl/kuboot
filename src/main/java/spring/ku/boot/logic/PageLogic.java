package spring.ku.boot.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.ku.boot.exception.WebException;
import spring.ku.boot.model.Page;
import spring.ku.boot.service.PageReadService;
import spring.ku.boot.service.PageWriteService;
import java.util.Optional;

@Component
public class PageLogic {

    private final PageWriteService pageWriteService;

    private final PageReadService pageReadService;


    @Autowired
    public PageLogic(PageWriteService pageWriteService, PageReadService pageReadService) {
        this.pageWriteService = pageWriteService;
        this.pageReadService = pageReadService;
    }

    public String query(String id) {
        return pageReadService.query(id).orElseThrow(WebException::new).getContent();
    }

    public String save(Page page){
        Optional<Page> optional = pageWriteService.save(page);
        Page result = optional.orElseThrow(WebException::new);
        return result.getContent();
    }
}
