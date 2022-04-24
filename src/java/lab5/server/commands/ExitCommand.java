package lab5.server.commands;

import lab5.client.commands.ParamsChecker;
import lab5.common.Worker;
import lab5.common.dto.CommandRequestDto;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.List;

public class ExitCommand extends BaseCommand

        /**
         * exit command
         * command for exit
         */
{
    @Override
    protected void Execute(CommandRequestDto<? extends Serializable> params, LinkedHashSet<Worker> set) {
    }
}
