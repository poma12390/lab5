package lab5.commands;

import lab5.runners.ParamsChecker;
import lab5.common.Worker;

import java.util.LinkedHashSet;
import java.util.List;

public class ClearCommand extends BaseCommand{
    /**
     * clear command
     * clear collection
     */

    @Override
    protected void Execute(List<String> params, LinkedHashSet<Worker> set) {
        ParamsChecker.checkParams(0, params);
        set.clear();

    }
}
