package lab5.setterrs;

import lab5.common.Worker;
import lab5.common.exceptions.EmptyStringException;

public class SetName {
    public static void setname(String name, Worker bum) throws EmptyStringException {
        if (name.isEmpty()) {
            throw new EmptyStringException();
        } else {
            bum.setName(name);
        }
    }
}
