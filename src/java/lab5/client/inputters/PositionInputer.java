package lab5.client.inputters;

import lab5.common.exceptions.EmptyStringException;
import lab5.common.Position;

import java.io.BufferedReader;
import java.util.Locale;
import java.util.NoSuchElementException;

public class PositionInputer extends AbstractInputer<Position> {

    public PositionInputer(BufferedReader bufferedReader, boolean blockPrompt) {
        super(bufferedReader, blockPrompt);
    }

    @Override
    protected Position doInput(String line) throws NullPointerException, NoSuchElementException, EmptyStringException {
        if (line.isEmpty()){
            throw new EmptyStringException();
        }
        else {
            line = line.toUpperCase(Locale.ENGLISH);
            return Position.valueOf(line);
        }

    }

}
