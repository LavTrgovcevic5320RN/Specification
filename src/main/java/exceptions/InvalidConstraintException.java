package exceptions;

public class InvalidConstraintException extends RuntimeException{
    public InvalidConstraintException(String message) {
        super(message);
    }
}
