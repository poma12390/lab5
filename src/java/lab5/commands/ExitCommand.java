package lab5.commands;

import lab5.runners.Commands;
import lab5.runners.ParamsChecker;
import lab5.runners.Worker;

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
