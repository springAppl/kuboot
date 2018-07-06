package spring.ku.boot.criteria;

import lombok.Data;
import lombok.ToString;
import spring.ku.boot.dao.PageCriteria;

import java.io.Serializable;

@Data
@ToString
public class ArticleCriteria extends PageCriteria implements Serializable {
    private static final long serialVersionUID = 6172008972891857205L;
    private Long id;
    private String title;

    public ArticleCriteria(Integer pageNo, Integer pageSize) {
        super(pageNo, pageSize);
    }
}
