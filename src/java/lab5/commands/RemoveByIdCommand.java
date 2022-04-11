package lab5.commands;

import lab5.runners.ParamsChecker;
import lab5.runners.Worker;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class RemoveByIdCommand extends BaseCommand{
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
    protected void Execute(List<String> params, LinkedHashSet<Worker> set) {
        ParamsChecker.checkParams(1, params);
        Iterator<Worker> it = set.iterator();
        while (it.hasNext()) {
            Worker bum = it.next();
            Integer s = null;
            String v;
            s = bum.getId();
            v = Integer.toString(s);
            System.out.println(v);
            if (v.equals(params.get(0))) {
                set.remove(bum);
                return;
            }
        }
    }
}
