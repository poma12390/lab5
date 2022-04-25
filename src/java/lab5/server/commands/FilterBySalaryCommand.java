package lab5.server.commands;

import lab5.client.commands.ParamsChecker;
import lab5.common.Transformer;
import lab5.common.Worker;
import lab5.common.dto.CommandRequestDto;
import lab5.common.dto.FilterBySalaryCommandDto;
import lab5.common.dto.UpdateIdCommandDto;
import lab5.common.exceptions.InvalidSalaryException;
import lab5.server.ClientCaller;
import lab5.setterrs.SetSalary;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

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
        Float salary = filterBySalaryCommandDto.getSalary();

        String request ="";
        for (Worker bum : set) {
            if (bum.getSalary() == salary) {
                request = request + bum.toString();
                //System.out.println("чел " + bum.getId() + " " + bum.getName() + " зарабатывает " + bum.getSalary());
            }
        }
        if (request.equals("")){
            clientCaller.sendToClient(transformer.Serialize("No such guys"));
        }
        else clientCaller.sendToClient(transformer.Serialize(request));
    }
}

