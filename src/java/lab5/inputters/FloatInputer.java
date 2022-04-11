package lab5.inputters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;

public class FloatInputer extends AbstractInputer <Float>{

    public FloatInputer(BufferedReader bufferedReader, boolean blockPrompt) {
        super(bufferedReader, blockPrompt);
    }

    @Override
    protected Float doInput(String line) {
        return Float.parseFloat(line.replace("\r\n",""));
    }
}
