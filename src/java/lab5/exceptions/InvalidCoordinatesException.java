package lab5.exceptions;

/**
 * thrown when unable to create file
 */
public class InvalidCoordinatesException extends InvalidDataException{
    public InvalidCoordinatesException(){
        super("bad x or y");
    }
}
