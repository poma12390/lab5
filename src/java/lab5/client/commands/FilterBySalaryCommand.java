package lab5.client.commands;

import lab5.common.exceptions.InvalidSalaryException;

import java.util.List;

public class FilterBySalaryCommand extends BaseCommand {
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
    protected void Execute(List<String> params) throws InvalidSalaryException {

        ParamsChecker.checkParams(1, params);

    }
}
