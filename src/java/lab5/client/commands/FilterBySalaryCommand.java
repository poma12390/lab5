package lab5.client.commands;

import lab5.client.ServerReceiver;
import lab5.common.Worker;
import lab5.common.dto.CommandRequestDto;
import lab5.common.dto.FilterBySalaryCommandDto;
import lab5.common.dto.ShowCommandDto;
import lab5.common.exceptions.InvalidSalaryException;

import java.util.List;
import java.util.MissingFormatArgumentException;

public class FilterBySalaryCommand extends BaseCommand {
    @Override
    public String getName() {
        return "filter_by_salary";
    }

    @Override
    protected int getCommandParamsCount() {
        return 1;
    }

    /**
     * FilterBySalary command
     * show elements sorted by salary
     */

    @Override
    protected void Execute(List<String> params) throws InvalidSalaryException {
        ParamsChecker.checkParams(1, params);

        FilterBySalaryCommandDto dto= new FilterBySalaryCommandDto();

        try {
            float salary = Float.parseFloat(params.get(0));
            dto.setSalary(salary);
        } catch (Exception e) {
            throw  new MissingFormatArgumentException("param should be float");
        }
        CommandRequestDto<FilterBySalaryCommandDto> crd = new CommandRequestDto<>(getName(), dto);
        serverCaller.sendToServer(transformer.Serialize(crd));
        byte[] buf = ServerReceiver.receiveFromServer();
        String response = (String) transformer.DeSerialize(buf);
        System.out.println(response);

    }
}
