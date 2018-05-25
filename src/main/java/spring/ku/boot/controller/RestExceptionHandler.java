package spring.ku.boot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;
import spring.ku.boot.exception.ExceptionEntity;
import spring.ku.boot.exception.WebException;

//@ControllerAdvice
public class RestExceptionHandler {
    //@ExceptionHandler(WebException.class)
    protected ResponseEntity<Object> handleInvalidRequest(WebException e, WebRequest request) {
        HttpStatus httpStatus = HttpStatus.valueOf(500);
        ExceptionEntity exceptionEntity = new ExceptionEntity();
        exceptionEntity.setStatus(httpStatus.value());
        exceptionEntity.setMessage(e.getMessage());
        return new ResponseEntity<>(exceptionEntity, httpStatus);
    }
}
