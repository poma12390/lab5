package lab5.commands;

import lab5.runners.Commands;
import lab5.client.commands.ParamsChecker;
import lab5.common.Worker;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

import static lab5.runners.Commands.makeId;

public class AddIfMinCommand extends BaseCommand{
    @Override
    public String getName() {
        return "add_If_min";
    }

    /**
     * addIfMin command
     * add new Worker if it's min in coll
     */

    @Override
    protected void Execute(List<String> params, LinkedHashSet<Worker> set) throws IOException {
        ParamsChecker.checkParams(0, params);
        Worker bum = new Worker();
        Commands.updateAll(bum);
        if (set.size() == 0) {
            bum = makeId(bum);
            set.add(bum);
        } else {
            Worker min = Collections.min(set);
            if (bum.compareTo(min) > 0) {
                bum = makeId(bum);
                set.add(bum);
                System.out.println("success");
            } else {
                System.out.println("not min element");
            }
        }

    }
}
