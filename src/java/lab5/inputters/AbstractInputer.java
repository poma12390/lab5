package lab5.inputters;

import lab5.exceptions.InvalidSalaryException;
import lab5.runners.Commands;
import lab5.exceptions.InvalidDateFormatException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.NoSuchElementException;

public abstract class AbstractInputer<T> {

    private final InputStream inputStream = System.in;
    private final InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
    private final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

    /**
     * inputvalide command
     * @param name validate string to convert
     */

    public T inputValue(String name) {
        name = name.trim();
        while (true) {
            try {
                System.out.print("введите " + name + " ");
                return doInput();
            } catch (NumberFormatException e) {
                System.out.println("not a number ");
            }
            catch (InvalidSalaryException e){
                System.out.println("salary must be >=0");
            }
            catch (NullPointerException | NoSuchElementException e) {
                Commands.funExit();
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    protected abstract T doInput() throws IOException, InvalidDateFormatException, ParseException, NullPointerException, NoSuchElementException, InvalidSalaryException;


    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }
}
