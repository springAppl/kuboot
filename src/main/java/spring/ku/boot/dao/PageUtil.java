package spring.ku.boot.dao;

import lombok.Data;
import lombok.ToString;

import java.util.Objects;

/**
 * @author lsf
 */
@Data
@ToString
public class PageUtil {

    private Integer offset;

    private Integer limit;


    public PageUtil(Integer pageNo, Integer pageSize){
        pageNo = Objects.isNull(pageNo) ? 1 : pageNo;
        pageSize = Objects.isNull(pageSize) ? 20 : pageSize;
        offset = (pageNo - 1) * pageSize;
        limit = pageSize;
    }


}
