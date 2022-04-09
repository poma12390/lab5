package lab5.inputters;

import java.io.IOException;

public class LongInputer extends AbstractInputer<Long> {

    @Override
    protected Long doInput() throws IOException {
        return Long.parseLong(getBufferedReader().readLine());
    }

}
