package lab5.client.commands;

import lab5.client.ServerCaller;
import lab5.common.Transformer;

import java.util.List;

public class RemoveByIdCommand extends BaseCommand {
    @Override
    public String getName() {
        return "remove_by_id";
    }

    @Override
    protected int getCommandParamsCount() {
        return 1;
    }

    /**
     * removeById command
     * @param params id of worker to delete
     * delete worker from collections with id
     */

    @Override
    protected void Execute(List<String> params, ServerCaller serverCaller, Transformer transformer) {
        ParamsChecker.checkParams(1, params);

    }
}
