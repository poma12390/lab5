package lab5.inputters;

import lab5.exceptions.InvalidDateFormatException;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Datainputer extends AbstractInputer<Date> {
    @Override
    protected Date doInput() throws IOException, InvalidDateFormatException, ParseException {
        String regex = "\\d{2}\\.\\d{2}.\\d{4}";
        String s = getBufferedReader().readLine();
        if (s.matches(regex)) {
            String[] items = s.split("\\.");
            int y = Integer.parseInt(items[0]);
            int y1 = Integer.parseInt(items[1]);
            if (y>31 | y1 > 12){
                throw new InvalidDateFormatException();
            }
            else {
                SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
                Date date = formatter.parse(s);
                return date;
            }
        } else {
            throw new InvalidDateFormatException();
        }
    }
}
