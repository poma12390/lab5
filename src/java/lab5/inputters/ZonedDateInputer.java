package lab5.inputters;

import lab5.exceptions.InvalidDateFormatException;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class ZonedDateInputer extends AbstractInputer<ZonedDateTime> {
    @Override
    protected ZonedDateTime doInput() throws IOException, InvalidDateFormatException, ParseException {
        String regex = "\\d{2}\\.\\d{2}.\\d{4}";
        String s = getBufferedReader().readLine();
        if (s.matches(regex)) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
            Date date = formatter.parse(s);
            ZoneId defaultZoneId = ZoneId.systemDefault();
            Instant instant = date.toInstant();
            return instant.atZone(defaultZoneId);
        } else {
            throw new InvalidDateFormatException();
        }
    }
}
