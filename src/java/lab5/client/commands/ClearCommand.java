package lab5.client.commands;

import lab5.client.ServerReceiver;
import lab5.common.dto.AddCommandDto;
import lab5.common.dto.ClearCommandDto;
import lab5.common.dto.CommandRequestDto;
import lab5.common.dto.CommandResponseDto;

import java.util.List;

public class ClearCommand extends BaseCommand {
    /**
     * clear command
     * clear collection
     */

    @Override
    protected void Execute(List<String> params) {
        ParamsChecker.checkParams(0, params);
        ClearCommandDto dto = new ClearCommandDto();
        CommandRequestDto<ClearCommandDto> crd = new CommandRequestDto<>("clear", dto);
        serverCaller.sendToServer(transformer.Serialize(crd));

        byte[] buf = ServerReceiver.receiveFromServer();
        CommandResponseDto response = (CommandResponseDto) transformer.DeSerialize(buf);
        System.out.println(response.getResponse());

    }
}
