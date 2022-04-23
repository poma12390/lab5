package lab5.commands;

import lab5.common.exceptions.EmptyCollectionException;
import lab5.client.commands.ParamsChecker;
import lab5.common.Worker;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

public class RemoveLowerCommand extends BaseCommand{
    @Override
    public String getName() {
        return "remove_lower";
    }

    /**
     * removeLower command
     * remove lower element from collection
     */

    @Override
    protected void Execute(List<String> params, LinkedHashSet<Worker> set) {
        ParamsChecker.checkParams(0, params);
        if (set.size() == 0) {
            throw new EmptyCollectionException();
        }
        Worker min = Collections.min(set);
        set.remove(min);
    }
}
