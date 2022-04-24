package lab5.server.commands;

import lab5.client.commands.ParamsChecker;
import lab5.common.Worker;
import lab5.common.dto.CommandRequestDto;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.List;

public class ClearCommand extends BaseCommand {
    /**
     * clear command
     * clear collection
     */

    @Override
    protected void Execute(CommandRequestDto<? extends Serializable> params, LinkedHashSet<Worker> set) {


    }
}
