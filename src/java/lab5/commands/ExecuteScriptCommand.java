package lab5.commands;

import lab5.memory.OverflowChecker;
import lab5.runners.Commands;
import lab5.runners.ParamsChecker;
import lab5.runners.Worker;

import java.util.LinkedHashSet;
import java.util.List;

public class ExecuteScriptCommand extends BaseCommand{
    @Override
    protected int getCommandParamsCount() {
        return 1;
    }
    /**
     * executeScript command
     * @param params filename to complete script
     * run all commands from file
     */
    @Override
    protected void Execute(List<String> params, LinkedHashSet<Worker> set) {
        String s = "";
        ParamsChecker.checkParams(1, params);
        s = Commands.open(params.get(0));
        if (s.isEmpty()) {
            return;
        }
        OverflowChecker.checkRec(params.get(0));
        String[] commands = s.split("\r\n");
        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            System.out.println("doing " + command);
            Commands.runCommandFromString(set, command);
        }

    }
}
