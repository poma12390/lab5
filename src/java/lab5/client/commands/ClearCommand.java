package lab5.client.commands;

import lab5.client.ServerCaller;
import lab5.common.Transformer;

import java.util.List;

public class ClearCommand extends BaseCommand {
    /**
     * clear command
     * clear collection
     */

    @Override
    protected void Execute(List<String> params, ServerCaller serverCaller, Transformer transformer) {
        ParamsChecker.checkParams(0, params);


    }
}
