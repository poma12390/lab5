package lab5.client.commands;

import lab5.client.ServerCaller;
import lab5.common.Transformer;

import java.util.List;

public class RemoveLowerCommand extends BaseCommand {
    @Override
    public String getName() {
        return "remove_lower";
    }

    /**
     * removeLower command
     * remove lower element from collection
     */

    @Override
    protected void Execute(List<String> params, ServerCaller serverCaller, Transformer transformer) {
        ParamsChecker.checkParams(0, params);

    }
}
