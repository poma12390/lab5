package lab5.client.commands;

import lab5.client.ServerReceiver;
import lab5.common.dto.CommandRequestDto;
import lab5.common.dto.CommandResponseDto;
import lab5.common.dto.RemoveAllByEndDateCommandDto;
import lab5.common.dto.RemoveByIdCommandDto;

import java.util.List;
import java.util.MissingFormatArgumentException;

public class RemoveByIdCommand extends BaseCommand {
    @Override
    public String getName() {
        return "remove_by_id";
    }

    @Override
    protected int getCommandParamsCount() {
        return 1;
    }

    /**
     * removeById command
     * @param params id of worker to delete
     * delete worker from collections with id
     */

    @Override
    protected void Execute(List<String> params) {
        ParamsChecker.checkParams(1, params);
        RemoveByIdCommandDto dto = new RemoveByIdCommandDto();
        CommandRequestDto<RemoveByIdCommandDto> crd = new CommandRequestDto<>(getName(), dto);

        try {
            int id = Integer.parseInt(params.get(0));
            dto.setId(id);
        } catch (Exception e) {
            throw  new MissingFormatArgumentException("param should be int");
        }

        serverCaller.sendToServer(transformer.Serialize(crd));

        byte[] buf = ServerReceiver.receiveFromServer();
        CommandResponseDto response = (CommandResponseDto) transformer.DeSerialize(buf);
        dto = (RemoveByIdCommandDto) response.getCommandArgs();
        long count = dto.getCount();
        System.out.println("Deleted " +count + " elements");

    }
}
