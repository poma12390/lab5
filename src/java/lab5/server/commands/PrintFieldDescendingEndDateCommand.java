package lab5.server.commands;

import lab5.client.commands.ParamsChecker;
import lab5.common.Worker;
import lab5.common.dto.CommandRequestDto;

import java.io.Serializable;
import java.util.*;

public class PrintFieldDescendingEndDateCommand extends BaseCommand {
    @Override
    public String getName() {
        return "print_field_descending_endDate";
    }

    /**
     * printFieldDescendingDate command
     * show sorted endDate
     */

    @Override
    protected void Execute(CommandRequestDto<? extends Serializable> params, LinkedHashSet<Worker> set) {

    }
}
