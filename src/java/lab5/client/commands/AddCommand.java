package lab5.client.commands;

import lab5.client.ServerReceiver;
import lab5.common.Transformer;
import lab5.common.Worker;
import lab5.common.dto.AddCommandDto;
import lab5.common.dto.CommandRequestDto;
import lab5.common.dto.WorkerDto;
import lab5.common.exceptions.InvalidDateFormatException;
import lab5.common.exceptions.InvalidEndDateException;
import lab5.common.exceptions.InvalidSalaryException;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class AddCommand extends BaseCommand {
    @Override
    protected void Execute(List<String> params) throws IOException, InvalidSalaryException, InvalidDateFormatException, ParseException, InvalidEndDateException {
        ParamsChecker.checkParams(0, params);
        Worker bum = new Worker();
        Utils.updateAll(bum);

        AddCommandDto dto= new AddCommandDto();
        WorkerDto man = Transformer.WorkerToWorkerDto(bum);
        dto.setBum(man);
        CommandRequestDto<AddCommandDto> crd = new CommandRequestDto<>("add", dto);
        serverCaller.sendToServer(transformer.Serialize(crd));

        byte[] buf = ServerReceiver.receiveFromServer();
        String response = (String) transformer.DeSerialize(buf);
        System.out.println(response);

    }
}
