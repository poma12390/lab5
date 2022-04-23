package lab5.common.exceptions;

public class InvalidSalaryException extends InvalidDataException {
    public InvalidSalaryException(){
        super("Bad salary bro");
    }
}
