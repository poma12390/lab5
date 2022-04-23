package lab5.client.commands;

import lab5.common.Worker;
import lab5.common.exceptions.InvalidDateFormatException;
import lab5.common.exceptions.InvalidEndDateException;
import lab5.common.exceptions.InvalidSalaryException;
import lab5.runners.Commands;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class AddCommand extends BaseCommand {
    @Override
    protected void Execute(List<String> params) throws IOException, InvalidSalaryException, InvalidDateFormatException, ParseException, InvalidEndDateException {
        ParamsChecker.checkParams(0, params);
        Worker bum = new Worker();
        Commands.updateAll(bum);
    }
}
