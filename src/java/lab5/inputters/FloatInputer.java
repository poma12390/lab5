package lab5.inputters;

import java.io.IOException;

public class FloatInputer extends AbstractInputer <Float>{
    @Override
    protected Float doInput() throws IOException {
        return Float.parseFloat(getBufferedReader().readLine().replace("\r\n",""));
    }
}
