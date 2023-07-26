package vmo.javaweb.demo.exception_handler.exceptions;

public class ServiceNotFound extends RuntimeException{
    public ServiceNotFound (String message){
        super(message);
    }
}
