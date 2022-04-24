package lab5.client.commands;

import java.util.List;

public class ClearCommand extends BaseCommand {
    /**
     * clear command
     * clear collection
     */

    @Override
    protected void Execute(List<String> params) {
        ParamsChecker.checkParams(0, params);


    }
}
