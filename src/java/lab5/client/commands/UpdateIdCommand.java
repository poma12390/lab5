package lab5.client.commands;

import lab5.client.ServerCaller;
import lab5.common.Transformer;

import java.io.IOException;
import java.util.List;

public class UpdateIdCommand extends BaseCommand {
    @Override
    protected int getCommandParamsCount() {
        return 1;
    }

    /**
     * update command
     * @param params id Worker to update
     * update all stats
     */
    @Override
    protected void Execute(List<String> params, ServerCaller serverCaller, Transformer transformer) throws IOException {
        ParamsChecker.checkParams(1, params);

    }
}
