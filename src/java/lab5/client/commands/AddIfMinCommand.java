package lab5.client.commands;

import lab5.common.Worker;
import lab5.runners.Commands;

import java.io.IOException;
import java.util.List;

public class AddIfMinCommand extends BaseCommand {
    @Override
    public String getName() {
        return "add_If_min";
    }

    /**
     * addIfMin command
     * add new Worker if it's min in coll
     */

    @Override
    protected void Execute(List<String> params) throws IOException {
        ParamsChecker.checkParams(0, params);
        Worker bum = new Worker();
        Commands.updateAll(bum);

    }
}
