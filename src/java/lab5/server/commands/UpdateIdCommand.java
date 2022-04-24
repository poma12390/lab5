package lab5.server.commands;

import lab5.client.commands.ParamsChecker;
import lab5.common.Worker;
import lab5.common.dto.CommandRequestDto;
import lab5.runners.Commands;

import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class UpdateIdCommand extends BaseCommand {
    @Override
    protected int getCommandParamsCount() {
        return 1;
    }

    /**
     * update command
     * @param params id Worker to update
     * update all stats
     */
    @Override
    protected void Execute(CommandRequestDto<? extends Serializable> params, LinkedHashSet<Worker> set) throws IOException {

    }
}
