package lab5.server.commands;

import lab5.client.commands.ParamsChecker;
import lab5.common.Transformer;
import lab5.common.Worker;
import lab5.common.dto.ClearCommandDto;
import lab5.common.dto.CommandRequestDto;
import lab5.common.dto.CommandResponseDto;
import lab5.server.ClientCaller;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.List;

public class ClearCommand extends BaseCommand {
    /**
     * clear command
     * clear collection
     */

    @Override
    protected void Execute(CommandRequestDto<? extends Serializable> params, LinkedHashSet<Worker> set, Transformer transformer, ClientCaller clientCaller) {

        set.clear();
        CommandResponseDto dto = new CommandResponseDto(new ClearCommandDto());
        dto.setResponse("success");
        clientCaller.sendToClient(transformer.Serialize(dto));
    }
}
