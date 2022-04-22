package lab5.exceptions;

public class ServerNotFoundException extends RuntimeException{
    public ServerNotFoundException(){
        super("Server not found");
    }
}
