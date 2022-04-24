package lab5.client.commands;

import lab5.client.ServerCaller;
import lab5.common.Transformer;
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
        ServerCaller serverCaller = new ServerCaller();
        Transformer transformer = new Transformer();
        serverCaller.sendToServer(transformer.Serialize(crd));
    }
}
