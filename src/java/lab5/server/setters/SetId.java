package lab5.server.setters;

import lab5.common.Worker;
import lab5.common.exceptions.DublicateIdException;
import lab5.common.exceptions.EmptyStringException;

import static lab5.server.commands.Commands.getIds;

public class SetId {
    public static void setId(String id, Worker bum) throws EmptyStringException, DublicateIdException {
        if (id.isEmpty()) {
            throw new EmptyStringException();
        } else {
            int f = Integer.parseInt(id);
            if (f < 0) {
                throw new EmptyStringException();
            } else {
                if (getIds().contains(f)){
                    throw new DublicateIdException();
                }
                else{
                    bum.setId(f);
                    getIds().add(f);
                }

            }
        }
    }
}
