package lab5.server.commands;

import lab5.client.commands.ParamsChecker;
import lab5.common.Transformer;
import lab5.common.Worker;
import lab5.common.dto.CommandRequestDto;
import lab5.common.dto.UpdateIdCommandDto;
import lab5.server.ClientCaller;

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
     *
     * @param params id Worker to update
     *               update all stats
     */
    @Override
    protected void Execute(CommandRequestDto<? extends Serializable> params, LinkedHashSet<Worker> set, Transformer transformer, ClientCaller clientCaller) throws IOException {
        UpdateIdCommandDto updateIdCommandDto = (UpdateIdCommandDto) params.getCommandArgs();
        if (updateIdCommandDto.getWorkerDto() != null) {
            Worker newbum = Transformer.WorkerDtoToWorker(updateIdCommandDto.getWorkerDto());
            Worker bum = Commands.getWorkerById(updateIdCommandDto.getWorkerId());
            Transformer.WorkerToWorker(bum, newbum);
            clientCaller.sendToClient(transformer.Serialize("Success"));
        } else {
            if (Commands.getIds().contains(updateIdCommandDto.getWorkerId())) {
                clientCaller.sendToClient(transformer.Serialize("Correct id"));
            } else clientCaller.sendToClient(transformer.Serialize("UnCorrect Id"));
        }
    }
}
