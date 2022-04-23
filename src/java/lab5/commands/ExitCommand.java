package lab5.commands;

import lab5.client.commands.ParamsChecker;
import lab5.common.Worker;

import java.util.LinkedHashSet;
import java.util.List;

public class ExitCommand extends BaseCommand

        /**
         * exit command
         * command for exit
         */
{
    @Override
    protected void Execute(List<String> params, LinkedHashSet<Worker> set) {
        ParamsChecker.checkParams(0, params);
        System.out.println("bye");
        System.exit(0);
    }
}
