package lab5.server.commands;

import lab5.common.Transformer;
import lab5.common.Worker;
import lab5.common.dto.CommandRequestDto;
import lab5.common.dto.CommandResponseDto;
import lab5.common.dto.ShowCommandDto;
import lab5.server.ClientCaller;

import java.io.Serializable;
import java.util.*;

public class ShowCommand extends BaseCommand {

    /**
     * show command
     * show all obj from in Collection
     */

    @Override
    protected void Execute(CommandRequestDto<? extends Serializable> params, LinkedHashSet<Worker> set, Transformer transformer, ClientCaller clientCaller) {
        ShowCommandDto showCommandDto = new ShowCommandDto();
        showCommandDto.setWorkers(new ArrayList<>(set));
            //Commands.show(params, set);
        CommandResponseDto dto = new CommandResponseDto(showCommandDto);
        clientCaller.sendToClient(transformer.Serialize(dto));
    }
}

