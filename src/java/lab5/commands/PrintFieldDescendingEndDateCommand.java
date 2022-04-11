package lab5.commands;

import lab5.runners.ParamsChecker;
import lab5.runners.Worker;

import java.util.*;

public class PrintFieldDescendingEndDateCommand extends BaseCommand{
    @Override
    public String getName() {
        return "print_field_descending_endDate";
    }

    /**
     * printFieldDescendingDate command
     * show sorted endDate
     */

    @Override
    protected void Execute(List<String> params, LinkedHashSet<Worker> set) {
        ParamsChecker.checkParams(0, params);
        List<Date> dates = new ArrayList<Date>();
        Iterator<Worker> it = set.iterator();
        while (it.hasNext()) {
            Worker bum = it.next();
            dates.add(bum.getEndDate());

        }
        Collections.sort(dates);
        for (int i = 0; i < dates.size(); i++) {
            System.out.println(dates.get(i));
        }
    }
}
