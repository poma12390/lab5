package lab5.inputters;

import java.time.ZonedDateTime;
import java.util.Date;

public class InputUtils {
    public static Date inputData(String name) {
        Datainputer inputer = new Datainputer();
        return inputer.inputValue(name);
    }

    public static long inputLong(String name) {
        LongInputer inputer = new LongInputer();
        return inputer.inputValue(name);
    }

    public static ZonedDateTime inputZonedDate(String name) {
        ZonedDateInputer inputer = new ZonedDateInputer();
        return inputer.inputValue(name);
    }

    public static int inputInt(String name) {
        IntInputer inputer = new IntInputer();
        return inputer.inputValue(name);
    }

    public static Float inputFloat(String name) {
        FloatInputer inputer = new FloatInputer();
        return inputer.inputValue(name);
    }


}
