package lab5.commands;

import lab5.exceptions.InvalidDateFormatException;
import lab5.exceptions.InvalidEndDateException;
import lab5.runners.ParamsChecker;
import lab5.common.Worker;
import lab5.setterrs.SetData;

import java.text.ParseException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class RemoveAllByEndDateCommand extends BaseCommand{
    @Override
    public String getName() {
        return "remove_all_by_end_date";
    }

    @Override
    protected int getCommandParamsCount() {
        return 1;
    }

    /**
     * removeByEndDate command
     * @param params end date to delete elements with
     * delete elemets with input end date
     */

    @Override
    protected void Execute(List<String> params, LinkedHashSet<Worker> set) throws InvalidDateFormatException, ParseException, InvalidEndDateException {
        ParamsChecker.checkParams(1, params);
        String input = params.get(0);
        Iterator<Worker> it = set.iterator();
        Worker test = new Worker();
            SetData.setEndData(input, test);
            while (it.hasNext()) {
                Worker bum = it.next();
                if (bum.getEndDate().compareTo(test.getEndDate()) == 0) {
                    System.out.println("remove " + bum.getName());
                    set.remove(bum);
                    return;
                }
            }
            System.out.println("no equals data");
    }
}
