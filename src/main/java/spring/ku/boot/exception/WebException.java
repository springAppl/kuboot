package spring.ku.boot.exception;

public class WebException extends RuntimeException {

    private Integer code;


    public WebException(String message, Integer code){
        super(message);
        this.code = code;
    }

    public WebException(String message){
        this(message, 500);
    }

    public WebException(Integer code){
        this.code = code;
    }
}
