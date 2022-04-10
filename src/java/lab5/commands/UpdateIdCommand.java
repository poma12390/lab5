package lab5.commands;

import lab5.runners.Commands;
import lab5.runners.ParamsChecker;
import lab5.runners.Worker;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashSet;
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
    protected void Execute(List<String> params, LinkedHashSet<Worker> set) throws IOException {
        ParamsChecker.checkParams(1, params);
        Iterator<Worker> it = set.iterator();
        while (it.hasNext()) {
            Worker bum = it.next();
            Integer s = null;
            String v;
            s = bum.getId();
            v = Integer.toString(s);
            if (v.equals(params.get(0))) {
                Commands.updateAll(bum);
                return;
            }
        }
        System.out.println("no such guy");
    }
}
