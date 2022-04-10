package lab5.commands;

import lab5.runners.ParamsChecker;
import lab5.runners.Worker;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class InfoCommand extends BaseCommand{
    @Override
    protected void Execute(List<String> params, LinkedHashSet<Worker> set) {
        ParamsChecker.checkParams(0, params);
        try {
            if (set.size() == 0){
                System.out.println("collection is empty");
            }
            else{
                Iterator<Worker> it = set.iterator();
                Worker p1 = it.next();
                System.out.println("Type - Worker");
                System.out.println("Creation date - " + p1.getCreationDate());
            }

        } catch (Exception e) {
            if (e.getMessage().isEmpty()){
                System.out.println(e.getCause().getMessage());
            }
            else {
                System.out.println(e.getMessage());
            }
        }

    }
}
