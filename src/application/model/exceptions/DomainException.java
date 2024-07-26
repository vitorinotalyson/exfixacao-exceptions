package src.application.model.exceptions;

public class DomainException extends RuntimeException{
    public DomainException(String msg){
        super(msg);
    }
}
