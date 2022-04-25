package lab5.server.commands;

import lab5.client.commands.ParamsChecker;
import lab5.common.Transformer;
import lab5.common.Worker;
import lab5.common.dto.*;
import lab5.runners.Commands;
import lab5.server.ClientCaller;

import java.io.IOException;
import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

import static lab5.runners.Commands.makeId;

public class AddIfMinCommand extends BaseCommand {
    @Override
    public String getName() {
        return "add_If_min";
    }

    /**
     * addIfMin command
     * add new Worker if it's min in coll
     */

    @Override
    protected void Execute(CommandRequestDto<? extends Serializable> params, LinkedHashSet<Worker> set, Transformer transformer, ClientCaller clientCaller) throws IOException {
        AddIfMinCommandDto addIfMinCommandDto = (AddIfMinCommandDto) params.getCommandArgs();
        WorkerDto workerDto = addIfMinCommandDto.getBum();
        Worker bum = Transformer.WorkerDtoToWorker(workerDto);
        CommandResponseDto dto = new CommandResponseDto(addIfMinCommandDto);
        if (set.size() == 0) {
            bum = makeId(bum);
            set.add(bum);
        } else {
            Worker min = set.stream().min(Worker::compareTo).get(); //stream Api
            if (bum.compareTo(min) < 0) {
                bum = makeId(bum);
                set.add(bum);
                dto.setResponse("success");

            } else {
                dto.setResponse("not min element");
            }
        } clientCaller.sendToClient(transformer.Serialize(dto));

    }
}
