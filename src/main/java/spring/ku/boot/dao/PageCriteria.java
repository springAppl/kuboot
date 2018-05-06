package spring.ku.boot.dao;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author lsf
 */
@Data
@ToString
public abstract class PageCriteria implements Serializable {

    private static final long serialVersionUID = 8674451411757498335L;
    private Integer offset = 0;

    private Integer limit = 20;

    public void page(Integer pageNo, Integer pageSize) {
        PageUtil pageUtil = new PageUtil(pageNo, pageSize);
        offset = pageUtil.getOffset();
        limit = pageUtil.getLimit();
    }
}
