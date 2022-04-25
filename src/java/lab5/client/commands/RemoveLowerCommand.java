package lab5.client.commands;

import lab5.client.ServerReceiver;
import lab5.common.dto.CommandRequestDto;
import lab5.common.dto.CommandResponseDto;
import lab5.common.dto.RemoveByIdCommandDto;
import lab5.common.dto.RemoveLowerCommandDto;

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
    protected void Execute(List<String> params) {
        ParamsChecker.checkParams(0, params);
        RemoveLowerCommandDto dto = new RemoveLowerCommandDto();
        CommandRequestDto<RemoveLowerCommandDto> crd = new CommandRequestDto<>(getName(), dto);
        serverCaller.sendToServer(transformer.Serialize(crd));

        byte[] buf = ServerReceiver.receiveFromServer();

        CommandResponseDto response = (CommandResponseDto) transformer.DeSerialize(buf);

        System.out.println(response.getResponse());

    }
}
