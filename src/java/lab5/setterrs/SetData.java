package lab5.setterrs;

import lab5.common.exceptions.InvalidEndDateException;
import lab5.common.Worker;
import lab5.common.exceptions.InvalidDateFormatException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SetData {
    private static Date endDateMoreStartDate;
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
                endDateMoreStartDate = date;
                bum.setStartDate(date);
            }
        } else {
            throw new InvalidDateFormatException();
        }
    }
    public static void setEndData(String endDate, Worker bum) throws ParseException, InvalidDateFormatException, InvalidEndDateException {
        String regex = "\\d{2}\\.\\d{2}.\\d{4}";
        if (endDate.matches(regex)) {
            String[] items = endDate.split("\\.");
            int y = Integer.parseInt(items[0]);
            int y1 = Integer.parseInt(items[1]);
            if (y>31 | y1 > 12 ){
                throw new InvalidDateFormatException();
            }
            else {
                SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
                Date date = formatter.parse(endDate);
                if (date.compareTo(endDateMoreStartDate)<=0){
                    throw new InvalidEndDateException();
                }
                bum.setEndDate(date);
            }
        } else {
            throw new InvalidDateFormatException();
        }
    }
    public static void setCreationData(String crDate, Worker bum) throws InvalidDateFormatException, ParseException {
        String regex = "\\d{2}\\.\\d{2}.\\d{4}";
        if (crDate.isEmpty()){
            throw new InvalidDateFormatException();
        }
        else{if (crDate.matches(regex)) {
            String[] items = crDate.split("\\.");
            int y = Integer.parseInt(items[0]);
            int y1 = Integer.parseInt(items[1]);
            if (y>31 | y1 > 12 ){
                throw new InvalidDateFormatException();
            }
            else {
                SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
                Date date = formatter.parse(crDate);
                if (date.compareTo(endDateMoreStartDate)<0){
                    throw new InvalidDateFormatException();
                }
                bum.setCreationDate(date);
            }
        } else {
            throw new InvalidDateFormatException();
        }

        }
    }

}
