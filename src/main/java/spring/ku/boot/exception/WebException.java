package spring.ku.boot.exception;

import lombok.Data;

@Data
public class WebException extends RuntimeException {

    private Integer code;

    private Object[] args;


    public WebException(String message, Integer code, Object[] args){
        super(message);
        this.code = code;
        this.args = args;
    }

    public WebException(String message, Integer code) {
        this(message, code, null);
    }

    public WebException(String message){
        this(message, new Object[]{});
    }

    public WebException(String message, Object[] args){
        this(message, 500, args);
    }

    public WebException(Integer code){
        this.code = code;
    }
}
