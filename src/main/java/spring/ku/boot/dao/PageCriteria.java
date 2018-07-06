package spring.ku.boot.dao;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author lsf
 */
@Data
@ToString
public abstract class PageCriteria implements Serializable {

    private static final long serialVersionUID = 8674451411757498335L;
    private Integer offset = 0;

    private Integer limit = 20;

    private Integer pageNo;

    private Integer pageSize;

    public PageCriteria(Integer pageNo, Integer pageSize) {
        if(Objects.isNull(pageNo)) {
            pageNo = 1;
        }
        this.pageNo = pageNo;
        if (Objects.isNull(pageSize)) {
            pageSize = 20;
        }
        this.pageSize = pageSize;
        PageUtil pageUtil = new PageUtil(pageNo, pageSize);
        offset = pageUtil.getOffset();
        limit = pageUtil.getLimit();
    }
}
