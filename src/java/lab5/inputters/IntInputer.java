package lab5.inputters;

import java.io.IOException;

public class IntInputer extends AbstractInputer<Integer> {

    @Override
    protected Integer doInput() throws IOException {

        return Integer.parseInt(getBufferedReader().readLine());
    }

}
