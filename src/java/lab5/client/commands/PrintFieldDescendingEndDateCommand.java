package lab5.client.commands;

import lab5.client.ServerCaller;
import lab5.common.Transformer;

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
    protected void Execute(List<String> params, ServerCaller serverCaller, Transformer transformer) {
        ParamsChecker.checkParams(0, params);

    }
}
