package spring.ku.boot.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;
import spring.ku.boot.dao.data.json.LocalDateTimeSerializer;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@ApiModel("用户店铺关联")
@Data
@ToString
@Entity
@Table(name = "user_shop")
public class UserShop  implements Serializable {

    private static final long serialVersionUID = -2805904391618084291L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "user_id")
    private Long userID;

    @Column(name = "shop_id")
    private Long shopID;

    @Column(name = "create_at")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createAt;

    @Column(name = "update_at")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime updateAt;
}
