package lab5.client.commands;

import lab5.client.ServerReceiver;
import lab5.common.Worker;
import lab5.common.dto.CommandRequestDto;
import lab5.common.dto.CommandResponseDto;
import lab5.common.dto.PrintFieldDescendingEndDateCommandDto;
import lab5.common.dto.ShowCommandDto;

import java.util.LinkedHashSet;
import java.util.List;

public class ShowCommand extends BaseCommand {

    /**
     * show command
     * show all obj from in Collection
     */

    @Override
    protected void Execute(List<String> params) {
        ParamsChecker.checkParams(0, params);

        ShowCommandDto dto= new ShowCommandDto();
        CommandRequestDto<ShowCommandDto> crd = new CommandRequestDto<>("show", dto);
        serverCaller.sendToServer(transformer.Serialize(crd));

        byte[] buf = ServerReceiver.receiveFromServer();
        CommandResponseDto response = (CommandResponseDto) transformer.DeSerialize(buf);
        dto = (ShowCommandDto) response.getCommandArgs();

        List<Worker> workers = (List<Worker>) dto.getWorkers();
        if (workers.size()==0)
            System.out.println("Collection is empty");
        for (Worker i : workers){
            System.out.print(i);
        }



    }
}
