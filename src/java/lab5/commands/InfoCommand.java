package lab5.commands;

import lab5.common.exceptions.EmptyCollectionException;
import lab5.client.commands.ParamsChecker;
import lab5.common.Worker;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class InfoCommand extends BaseCommand{
    @Override
    public String getName() {
        return "info";
    }

    /**
     * info command
     * command to show info aд
     */

    @Override
    protected void Execute(List<String> params, LinkedHashSet<Worker> set) {
        ParamsChecker.checkParams(0, params);
            if (set.size() == 0){
                throw  new EmptyCollectionException();
            }
            else{
                Iterator<Worker> it = set.iterator();
                Worker p1 = it.next();
                System.out.println("Type - Worker");
                System.out.println("Created date - " + p1.getCreationDate());
            }

    }
}
