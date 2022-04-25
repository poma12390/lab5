package lab5.server.commands;

import lab5.client.commands.ParamsChecker;
import lab5.common.Transformer;
import lab5.common.Worker;
import lab5.common.dto.CommandRequestDto;
import lab5.server.ClientCaller;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    protected void Execute(CommandRequestDto<? extends Serializable> params, LinkedHashSet<Worker> set, Transformer transformer, ClientCaller clientCaller) {

        List<Date> date = Arrays.stream(set.stream().flatMap((p) -> Stream.of(p.getEndDate())).toArray(Date[]::new)).sorted().collect(Collectors.toList());
        // Жестко переписал с Stream Api
        clientCaller.sendToClient(transformer.Serialize((Serializable) date));
    }
}
