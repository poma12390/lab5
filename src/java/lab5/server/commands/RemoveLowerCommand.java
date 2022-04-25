package lab5.server.commands;

import lab5.client.commands.ParamsChecker;
import lab5.common.Transformer;
import lab5.common.Worker;
import lab5.common.dto.CommandRequestDto;
import lab5.common.dto.CommandResponseDto;
import lab5.common.exceptions.EmptyCollectionException;
import lab5.server.ClientCaller;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

public class RemoveLowerCommand extends BaseCommand {
    @Override
    public String getName() {
        return "remove_lower";
    }

    /**
     * removeLower command
     * remove lower element from collection
     */

    @Override
    protected void Execute(CommandRequestDto<? extends Serializable> params, LinkedHashSet<Worker> set, Transformer transformer, ClientCaller clientCaller) {
        CommandResponseDto dto = new CommandResponseDto(params.getCommandArgs());
        if (set.size() == 0) {
            dto.setResponse("Collection is empty");
            clientCaller.sendToClient(transformer.Serialize(dto));
            throw new EmptyCollectionException();
        }
        Worker min = Collections.min(set);
        set.remove(min);

        dto.setResponse("success");
        clientCaller.sendToClient(transformer.Serialize(dto));
    }
}
