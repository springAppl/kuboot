package spring.ku.boot.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import spring.ku.boot.exception.ExceptionEntity;
import spring.ku.boot.exception.WebException;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(WebException.class)
    @ResponseBody
    protected Object handleInvalidRequest(WebException e, WebRequest request) {
        ExceptionEntity exceptionEntity = new ExceptionEntity();
        exceptionEntity.setStatus(500);
        exceptionEntity.setMessage(e.getMessage());
        return exceptionEntity;
    }
}
