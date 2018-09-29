package spring.ku.boot.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@ApiModel("页面")
@Data
@ToString
@Entity
@Table(name = "page")
public class Page implements Serializable {
    private static final long serialVersionUID = -5349839779283061309L;

    @Id
    private String id;

    private String content;
}
