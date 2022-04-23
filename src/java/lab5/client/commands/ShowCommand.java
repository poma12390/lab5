package lab5.client.commands;

import java.util.List;

public class ShowCommand extends BaseCommand {

    /**
     * show command
     * show all obj from in Collection
     */

    @Override
    protected void Execute(List<String> params) {
            ParamsChecker.checkParams(0, params);

    }
}
