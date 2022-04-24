package lab5.server.commands;

import lab5.client.commands.ParamsChecker;
import lab5.client.memory.OverflowChecker;
import lab5.common.Worker;
import lab5.common.dto.CommandRequestDto;
import lab5.common.exceptions.EndStreamException;
import lab5.runners.Commands;

import java.io.*;
import java.util.LinkedHashSet;
import java.util.List;

import static lab5.client.inputters.InputUtils.inputString;
import static lab5.runners.Commands.*;

public class ExecuteScriptCommand extends BaseCommand {
    @Override
    public String getName() {
        return "execute_script";
    }

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
    protected void Execute(CommandRequestDto<? extends Serializable> params, LinkedHashSet<Worker> set) {

}
}
