package lab5.commands;

import lab5.runners.Commands;
import lab5.runners.Worker;

import java.util.LinkedHashSet;
import java.util.List;

public class ExitCommand extends BaseCommand {
    @Override
    protected void Execute(List<String> params, LinkedHashSet<Worker> set) {
        Commands.exit(params, set);
    }
}
