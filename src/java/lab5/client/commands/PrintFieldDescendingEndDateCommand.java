package lab5.client.commands;

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
    protected void Execute(List<String> params) {
        ParamsChecker.checkParams(0, params);

    }
}
