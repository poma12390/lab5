package lab5.client.commands;

import lab5.client.ServerReceiver;
import lab5.common.dto.CommandRequestDto;
import lab5.common.dto.CommandResponseDto;
import lab5.common.dto.InfoCommandDto;
import lab5.common.dto.PrintFieldDescendingEndDateCommandDto;

import java.util.*;

public class PrintFieldDescendingEndDateCommand extends BaseCommand {
    @Override
    public String getName() {
        return "print_field_descending_end_date";
    }

    /**
     * printFieldDescendingDate command
     * show sorted endDate
     */

    @Override
    protected void Execute(List<String> params) {
        ParamsChecker.checkParams(0, params);
        PrintFieldDescendingEndDateCommandDto dto = new PrintFieldDescendingEndDateCommandDto();
        CommandRequestDto<PrintFieldDescendingEndDateCommandDto> crd = new CommandRequestDto<>(getName(), dto);

        serverCaller.sendToServer(transformer.Serialize(crd));

        byte[] buf = ServerReceiver.receiveFromServer();
        CommandResponseDto response = (CommandResponseDto) transformer.DeSerialize(buf);
        dto = (PrintFieldDescendingEndDateCommandDto) response.getCommandArgs();
        List<Date> responselist = dto.getDates();
        for (Date i : responselist){
            System.out.print(i + "; ");
        }
        System.out.println();
    }
}
