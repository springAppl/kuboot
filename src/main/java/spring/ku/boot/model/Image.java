package spring.ku.boot.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Image implements Serializable {

    private static final long serialVersionUID = -2546586752108263227L;

    private Long id;

    private byte[] data;
}
