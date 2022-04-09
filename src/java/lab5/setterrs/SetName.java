package lab5.setterrs;

import lab5.runners.Worker;
import lab5.exceptions.EmptyStringException;

public class SetName {
    public static void setname(String name, Worker bum) throws EmptyStringException {
        if (name.isEmpty()) {
            throw new EmptyStringException();
        } else {
            bum.setName(name);
        }
    }
}
