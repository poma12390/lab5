package lab5.server.commands;

import lab5.client.commands.ParamsChecker;
import lab5.common.Worker;
import lab5.common.dto.CommandRequestDto;
import lab5.runners.Commands;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.List;

import static lab5.runners.Commands.makeId;

public class AddCommand extends BaseCommand {
    /**
     * add command
     * add new Worker and set stats
     * */

    @Override
    protected void Execute(CommandRequestDto<? extends Serializable> params, LinkedHashSet<Worker> set) {

    }
}
