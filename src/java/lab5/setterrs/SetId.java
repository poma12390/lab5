package lab5.setterrs;

import lab5.exceptions.DublicateIdException;
import lab5.exceptions.EmptyStringException;
import lab5.exceptions.InvalidNumberException;
import lab5.runners.Commands;
import lab5.runners.Worker;

public class SetId {
    public static void setId(String id, Worker bum) throws EmptyStringException, DublicateIdException {
        if (id.isEmpty()) {
            throw new EmptyStringException();
        } else {
            int f = Integer.parseInt(id);
            if (f < 0) {
                throw new EmptyStringException();
            } else {
                if (Commands.getIds().contains(f)){
                    throw new DublicateIdException();
                }
                else{
                    bum.setId(f);
                    Commands.getIds().add(f);
                }

            }
        }
    }
}