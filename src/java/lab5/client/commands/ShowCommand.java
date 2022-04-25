package lab5.client.commands;

import lab5.client.ServerReceiver;
import lab5.common.Worker;
import lab5.common.dto.CommandRequestDto;
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

        LinkedHashSet<Worker> response = (LinkedHashSet<Worker>) transformer.DeSerialize(buf);
        if (response.size()==0)
            System.out.println("Collection is empty");
        for (Worker i : response){
            System.out.print(i);
        }



    }
}
