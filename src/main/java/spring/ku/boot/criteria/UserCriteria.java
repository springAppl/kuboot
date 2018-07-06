package spring.ku.boot.criteria;

import lombok.Data;
import lombok.ToString;
import spring.ku.boot.dao.PageCriteria;


import java.io.Serializable;

/**
 * @author lsf
 */
@Data
@ToString
public class UserCriteria extends PageCriteria implements Serializable {

    private static final long serialVersionUID = 3868847435723384290L;

    private Long id;


    private String name;


    public UserCriteria(Integer pageNo, Integer pageSize){
        super(pageNo, pageSize);
    }

}
