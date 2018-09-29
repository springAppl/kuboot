package spring.ku.boot.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;

@ApiModel("店铺")
@Data
@ToString
@Entity
@Table(name = "shop")
public class Shop implements Serializable {

    private static final long serialVersionUID = 725670032353420857L;

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Double longitude;

    private Double latitude;

    private String logo;

    @Column(name = "location_detail")
    private String locationDetail;

    private String phone;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_time")
    private LocalTime endTime;

    private String workTime;
}
