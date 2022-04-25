package lab5.client.commands;

import lab5.client.ServerReceiver;
import lab5.common.dto.CommandRequestDto;
import lab5.common.dto.InfoCommandDto;

import java.util.List;

public class InfoCommand extends BaseCommand {
    /**
     * info command
     * command to show info aд
     */

    @Override
    protected void Execute(List<String> params) {
        ParamsChecker.checkParams(0, params);
        InfoCommandDto dto = new InfoCommandDto();
        CommandRequestDto <InfoCommandDto> crd = new CommandRequestDto<>("info", dto);

        serverCaller.sendToServer(transformer.Serialize(crd));

        byte[] buf = ServerReceiver.receiveFromServer();
        String response = (String) transformer.DeSerialize(buf);
        System.out.println(response);
    }
}
