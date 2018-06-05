package spring.ku.boot.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class RestExceptionHandler {


    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(WebException.class)
    protected ResponseEntity handleInvalidRequest(WebException e, WebRequest request) {
        ExceptionEntity exceptionEntity = new ExceptionEntity();
        exceptionEntity.setStatus(e.getCode());
        exceptionEntity.setMessage(messageSource.getMessage(e.getMessage(),null, e.getMessage(), request.getLocale()));
        return new ResponseEntity(exceptionEntity, HttpStatus.valueOf(e.getCode()));
    }
}
