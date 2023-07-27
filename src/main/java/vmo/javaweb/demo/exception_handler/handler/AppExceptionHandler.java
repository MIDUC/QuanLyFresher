package vmo.javaweb.demo.exception_handler.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import vmo.javaweb.demo.exception_handler.exceptions.CenterNotFound;
import vmo.javaweb.demo.exception_handler.exceptions.ServiceNotFound;
import vmo.javaweb.demo.models.entity.ApiError;

import java.time.LocalDateTime;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(CenterNotFound.class)
    public ResponseEntity<Object> handleCenterNotFound(CenterNotFound ex , WebRequest request){
        return new ResponseEntity<Object>(new ApiError(HttpStatus.NOT_FOUND , ex.getMessage() , LocalDateTime.now()),HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(ServiceNotFound.class)
    public ResponseEntity<Object> handleServiceNotFound(ServiceNotFound ex , WebRequest request){
        return new ResponseEntity<Object>(new ApiError(HttpStatus.NOT_FOUND , ex.getMessage() , LocalDateTime.now()),HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return new ResponseEntity<Object>(new ApiError(HttpStatus.NOT_FOUND , ex.getMessage() , LocalDateTime.now()),HttpStatus.NOT_FOUND);
    }
}
