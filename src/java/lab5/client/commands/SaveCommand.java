package lab5.client.commands;

import java.io.IOException;
import java.util.List;

public class SaveCommand extends BaseCommand {

    /**
     * save command
     * save collection in csv file
     */

    @Override
    protected void Execute(List<String> params) throws IOException {
        ParamsChecker.checkParams(0,params);

    }
}
