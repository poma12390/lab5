package lab5.commands;

import lab5.runners.Commands;
import lab5.runners.ParamsChecker;
import lab5.common.Worker;

import java.util.LinkedHashSet;
import java.util.List;

import static lab5.runners.Commands.makeId;

public class AddCommand extends BaseCommand{
    /**
     * add command
     * add new Worker and set stats
     * */

    @Override
    protected void Execute(List<String> params, LinkedHashSet<Worker> set) {
            ParamsChecker.checkParams(0, params);
            Worker bum = new Worker();

            Commands.updateAll(bum);
            bum = makeId(bum);
            set.add(bum);
    }
}
