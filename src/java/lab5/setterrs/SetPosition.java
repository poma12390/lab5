package lab5.setterrs;

import lab5.runners.Position;
import lab5.runners.Worker;
import lab5.exceptions.EmptyStringException;

import java.util.Locale;

public class SetPosition {



    public static void setPosition(String pos, Worker bum) throws EmptyStringException {
        if (pos.isEmpty()){
            throw new EmptyStringException();
        }
        else {
            pos = pos.toUpperCase(Locale.ENGLISH);
            //System.out.println(pos);
            bum.setPosition(Position.valueOf(pos));
        }
    }
}
