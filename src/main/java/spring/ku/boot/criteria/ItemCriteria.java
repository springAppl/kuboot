package spring.ku.boot.criteria;

import lombok.Data;
import lombok.ToString;
import spring.ku.boot.dao.PageCriteria;

import java.io.Serializable;
@Data
@ToString
public class ItemCriteria extends PageCriteria implements Serializable {

    private static final long serialVersionUID = 2818214932404712398L;

    private Long id;

    private String name;

    public ItemCriteria(Integer pageNo, Integer pageSize) {
        super(pageNo, pageSize);
    }
}
