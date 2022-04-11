package lab5.inputters;

import lab5.exceptions.EmptyStringException;

import java.io.BufferedReader;
import java.util.NoSuchElementException;

public class StringInputer extends AbstractInputer<String> {

    public StringInputer(BufferedReader bufferedReader, boolean blockPrompt) {
        super(bufferedReader, blockPrompt);
    }

    @Override
    protected String doInput(String line) throws NullPointerException, NoSuchElementException, EmptyStringException {
        if (line.isEmpty())
            throw new EmptyStringException();
        return line;
    }
}
