package lab5.client.commands;

import lab5.client.ServerReceiver;
import lab5.common.Transformer;
import lab5.common.Worker;
import lab5.common.dto.AddCommandDto;
import lab5.common.dto.CommandRequestDto;
import lab5.common.dto.UpdateIdCommandDto;

import java.io.IOException;
import java.util.List;
import java.util.MissingFormatArgumentException;

public class UpdateIdCommand extends BaseCommand {
    @Override
    protected int getCommandParamsCount() {
        return 1;
    }

    /**
     * update command
     *
     * @param params id Worker to update
     *               update all stats
     */
    @Override
    protected void Execute(List<String> params) throws IOException {
        ParamsChecker.checkParams(1, params);
        UpdateIdCommandDto dto = new UpdateIdCommandDto();
        try {
            int id = Integer.parseInt(params.get(0));
            dto.setWorkerId(id);
        } catch (Exception e) {
            throw  new MissingFormatArgumentException("param should be int");
        }

        CommandRequestDto<UpdateIdCommandDto> crd = new CommandRequestDto<>("updateid", dto);
        serverCaller.sendToServer(transformer.Serialize(crd));

        byte[] buf = ServerReceiver.receiveFromServer();
        String response = (String) transformer.DeSerialize(buf);
        System.out.println(response);
        if (response.equals("Correct id")) {
            Worker bum = new Worker();
            Utils.updateAll(bum);
            dto.setWorkerDto(Transformer.WorkerToWorkerDto(bum));
            serverCaller.sendToServer(transformer.Serialize(crd));
            buf = ServerReceiver.receiveFromServer();
            response = (String) transformer.DeSerialize(buf);
            System.out.println(response);
        }


    }
}
