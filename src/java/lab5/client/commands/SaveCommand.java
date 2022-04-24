package lab5.client.commands;

import lab5.client.ServerCaller;
import lab5.common.Transformer;

import java.io.IOException;
import java.util.List;

public class SaveCommand extends BaseCommand {

    /**
     * save command
     * save collection in csv file
     */

    @Override
    protected void Execute(List<String> params, ServerCaller serverCaller, Transformer transformer) throws IOException {
        ParamsChecker.checkParams(0,params);

    }
}
