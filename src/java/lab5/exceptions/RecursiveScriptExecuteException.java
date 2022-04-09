package lab5.exceptions;
/**
 * thrown when script call loops
 */
public class RecursiveScriptExecuteException extends CommandException{
    public RecursiveScriptExecuteException(){
        super("recursive script execute attempt");
    }
}
