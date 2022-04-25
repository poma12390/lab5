package lab5.client.inputters;

import lab5.client.commands.Utils;
import lab5.common.exceptions.EmptyStringException;
import lab5.common.exceptions.EndStreamException;
import lab5.common.exceptions.InvalidDateFormatException;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.NoSuchElementException;

public abstract class AbstractInputer<T> {

    private final BufferedReader bufferedReader;
    private final boolean blockPrompt;

    protected AbstractInputer(BufferedReader bufferedReader, boolean blockPrompt) {
        this.bufferedReader = bufferedReader;
        this.blockPrompt = blockPrompt;
    }


    /**
     * inputvalide command
     * @param name validate string to convert
     */

    public T inputValue(String name) {
        name = name.trim();
        while (true) {
            try {
                if (!name.isEmpty() && !blockPrompt)
                    System.out.print("введите " + name + " ");
                String line = getBufferedReader().readLine();
                if (line == null)
                    throw new EndStreamException();
                line = line.trim();
                return doInput(line);
            } catch (NumberFormatException e) {
                if (!blockPrompt) System.out.println("not a number ");
            }
            catch (NullPointerException | NoSuchElementException e) {
                Utils.funExit();
            }
            catch (EndStreamException e) {
                throw e;
            }
            catch (Exception e){
                if (!blockPrompt) System.out.println(e.getMessage());
            }
        }
    }

    protected abstract T doInput(String line) throws IOException, InvalidDateFormatException, ParseException, NullPointerException, NoSuchElementException, EmptyStringException;


    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }
}
