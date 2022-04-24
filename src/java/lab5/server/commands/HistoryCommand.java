package lab5.server.commands;

import lab5.client.commands.ParamsChecker;
import lab5.client.memory.HistoryWork;
import lab5.common.Worker;
import lab5.common.dto.CommandRequestDto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class HistoryCommand extends BaseCommand {
    /**
     * history command
     * show last 5 commands without params
     */


    @Override
    protected void Execute(CommandRequestDto<? extends Serializable> params, LinkedHashSet<Worker> set) {
    }
}
