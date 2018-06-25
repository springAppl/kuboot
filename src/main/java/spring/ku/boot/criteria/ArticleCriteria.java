package spring.ku.boot.criteria;

import lombok.Data;
import lombok.ToString;
import spring.ku.boot.dao.PageCriteria;

import java.io.Serializable;

@Data
@ToString
public class ArticleCriteria extends PageCriteria implements Serializable {
    private String title;
}
