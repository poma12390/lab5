package lab5.server.commands;

import lab5.client.commands.ParamsChecker;
import lab5.common.Worker;
import lab5.common.dto.CommandRequestDto;
import lab5.common.exceptions.InvalidDateFormatException;
import lab5.common.exceptions.InvalidEndDateException;
import lab5.setterrs.SetData;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Iterator;
import java.util.LinkedHashSet;
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
    protected void Execute(CommandRequestDto<? extends Serializable> params, LinkedHashSet<Worker> set) throws InvalidDateFormatException, ParseException, InvalidEndDateException {

    }
}
