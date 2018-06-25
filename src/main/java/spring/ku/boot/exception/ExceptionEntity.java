package spring.ku.boot.exception;

import lombok.Data;

@Data
public class ExceptionEntity {
    private String message;
    private Integer httpCode;
}
