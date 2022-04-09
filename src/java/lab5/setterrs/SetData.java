package lab5.setterrs;

import lab5.runners.Worker;
import lab5.exceptions.InvalidDateFormatException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SetData {

    public static void  setStartData(String startDate, Worker bum) throws InvalidDateFormatException, ParseException {
        String regex = "\\d{2}\\.\\d{2}.\\d{4}";
        if (startDate.matches(regex)) {
            String[] items = startDate.split("\\.");
            int y = Integer.parseInt(items[0]);
            int y1 = Integer.parseInt(items[1]);
            if (y>31 | y1 > 12){
                throw new InvalidDateFormatException();
            }
            else {
                SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
                Date date = formatter.parse(startDate);
                bum.setStartDate(date);
            }
        } else {
            throw new InvalidDateFormatException();
        }
    }
    public static void setEndData(String endDate, Worker bum) throws ParseException, InvalidDateFormatException {
        String regex = "\\d{2}\\.\\d{2}.\\d{4}";
        if (endDate.matches(regex)) {
            String[] items = endDate.split("\\.");
            int y = Integer.parseInt(items[0]);
            int y1 = Integer.parseInt(items[1]);
            int y2 = Integer.parseInt(items[2]);
            if (y>31 | y1 > 12 | y2 < 2022){
                throw new InvalidDateFormatException();
            }
            else {
                SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
                Date date = formatter.parse(endDate);
                bum.setEndDate(date);
            }
        } else {
            throw new InvalidDateFormatException();
        }
    }

}
