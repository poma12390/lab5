package lab5.commands;

import lab5.common.exceptions.InvalidSalaryException;
import lab5.client.commands.ParamsChecker;
import lab5.common.Worker;
import lab5.setterrs.SetSalary;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class FilterBySalaryCommand extends BaseCommand{
    @Override
    public String getName() {
        return "filter_by_salary";
    }

    @Override
    protected int getCommandParamsCount() {
        return 1;
    }

    /**
     * FilterBySalary command
     * show elements sorted by salary
     */

    @Override
    protected void Execute(List<String> params, LinkedHashSet<Worker> set) throws InvalidSalaryException {

        ParamsChecker.checkParams(1, params);
        String salary = params.get(0);
        Iterator<Worker> it = set.iterator();
        Worker test = new Worker();
            SetSalary.setSalary(salary, test);
            while (it.hasNext()) {
                Worker bum = it.next();
                if (bum.getSalary() == test.getSalary()) {
                    System.out.println(bum.toString());
                    System.out.println("чел " + bum.getId() + " " + bum.getName() + " зарабатывает " + bum.getSalary());
                }
            }
    }
}
