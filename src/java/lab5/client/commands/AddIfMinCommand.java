package lab5.client.commands;

import lab5.client.ServerReceiver;
import lab5.common.Transformer;
import lab5.common.Worker;
import lab5.common.dto.AddIfMinCommandDto;
import lab5.common.dto.CommandRequestDto;
import lab5.common.dto.CommandResponseDto;
import lab5.common.dto.WorkerDto;

import java.io.IOException;
import java.util.List;

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
    protected void Execute(List<String> params) throws IOException {
        ParamsChecker.checkParams(0, params);
        Worker bum = new Worker();
        Utils.updateAll(bum);

        AddIfMinCommandDto dto= new AddIfMinCommandDto();
        WorkerDto man = Transformer.WorkerToWorkerDto(bum);
        dto.setBum(man);
        CommandRequestDto<AddIfMinCommandDto> crd = new CommandRequestDto<>("add_if_min", dto);
        serverCaller.sendToServer(transformer.Serialize(crd));

        byte[] buf = ServerReceiver.receiveFromServer();
        CommandResponseDto response = (CommandResponseDto) transformer.DeSerialize(buf);
        System.out.println(response.getResponse());

    }
}
