package lab5.server.commands;

import lab5.common.Transformer;
import lab5.common.Worker;
import lab5.common.dto.AddCommandDto;
import lab5.common.dto.CommandRequestDto;
import lab5.common.dto.CommandResponseDto;
import lab5.common.dto.WorkerDto;
import lab5.server.ClientCaller;

import java.io.Serializable;
import java.util.LinkedHashSet;

public class AddCommand extends BaseCommand {
    /**
     * add command
     * add new Worker and set stats
     * */

    @Override
    protected void Execute(CommandRequestDto<? extends Serializable> params, LinkedHashSet<Worker> set, Transformer transformer, ClientCaller clientCaller) {
        AddCommandDto addCommandDto = (AddCommandDto) params.getCommandArgs();
        WorkerDto workerDto = addCommandDto.getBum();
        Worker bum = Transformer.WorkerDtoToWorker(workerDto);
        lab5.server.commands.Commands.makeId(bum);
        set.add(bum);
        CommandResponseDto dto = new CommandResponseDto(addCommandDto);
        dto.setResponse("success");
        clientCaller.sendToClient(transformer.Serialize(dto));
    }
}
