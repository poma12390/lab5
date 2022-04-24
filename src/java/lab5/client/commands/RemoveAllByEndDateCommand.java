package lab5.client.commands;

import lab5.client.ServerCaller;
import lab5.common.Transformer;
import lab5.common.exceptions.InvalidDateFormatException;
import lab5.common.exceptions.InvalidEndDateException;

import java.text.ParseException;
import java.util.List;

public class RemoveAllByEndDateCommand extends BaseCommand {
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
    protected void Execute(List<String> params, ServerCaller serverCaller, Transformer transformer) throws InvalidDateFormatException, ParseException, InvalidEndDateException {
        ParamsChecker.checkParams(1, params);

    }
}
