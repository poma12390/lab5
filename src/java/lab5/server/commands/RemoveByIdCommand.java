package lab5.server.commands;

import lab5.client.commands.ParamsChecker;
import lab5.common.Transformer;
import lab5.common.Worker;
import lab5.common.dto.CommandRequestDto;
import lab5.common.dto.RemoveAllByEndDateCommandDto;
import lab5.common.dto.RemoveByIdCommandDto;
import lab5.server.ClientCaller;

import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class RemoveByIdCommand extends BaseCommand {
    @Override
    public String getName() {
        return "remove_by_id";
    }

    @Override
    protected int getCommandParamsCount() {
        return 1;
    }

    /**
     * removeById command
     * @param params id of worker to delete
     * delete worker from collections with id
     */

    @Override
    protected void Execute(CommandRequestDto<? extends Serializable> params, LinkedHashSet<Worker> set, Transformer transformer, ClientCaller clientCaller) {
        RemoveByIdCommandDto removeByIdCommandDto = (RemoveByIdCommandDto) params.getCommandArgs();
        int id = removeByIdCommandDto.getId();
        long count = (set.stream().filter((p) -> p.getId() == id).count());
        set.removeIf(worker -> worker.getId() == id);
        clientCaller.sendToClient(transformer.Serialize(count));


        }
}


