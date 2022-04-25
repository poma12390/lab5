package lab5.server.commands;

import lab5.common.Transformer;
import lab5.common.Worker;
import lab5.common.dto.CommandRequestDto;
import lab5.common.dto.CommandResponseDto;
import lab5.common.dto.FilterBySalaryCommandDto;
import lab5.common.exceptions.InvalidSalaryException;
import lab5.server.ClientCaller;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    protected void Execute(CommandRequestDto<? extends Serializable> params, LinkedHashSet<Worker> set, Transformer transformer, ClientCaller clientCaller) throws InvalidSalaryException {
        FilterBySalaryCommandDto filterBySalaryCommandDto = (FilterBySalaryCommandDto) params.getCommandArgs();
        float salary = filterBySalaryCommandDto.getSalary();
        String response = "";

        List<Worker> workers = (set.stream().filter((p) -> p.getSalary() == salary).collect(Collectors.toList())); // Получаем нужных челов
        //System.out.println(workers);
        response = response + "Всего найдено " + workers.size() + " челов" + "\r\n";
        filterBySalaryCommandDto.setWorkers(workers);
        CommandResponseDto dto = new CommandResponseDto(filterBySalaryCommandDto);
        dto.setResponse(response);
        clientCaller.sendToClient(transformer.Serialize(dto));
    }
}


