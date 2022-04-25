package lab5.server.commands;

import lab5.client.commands.ParamsChecker;
import lab5.common.Transformer;
import lab5.common.Worker;
import lab5.common.dto.CommandRequestDto;
import lab5.server.ClientCaller;

import java.io.Serializable;
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
    protected void Execute(CommandRequestDto<? extends Serializable> params, LinkedHashSet<Worker> set, Transformer transformer, ClientCaller clientCaller) {
        String response = "";
        List<Date> dates = new ArrayList<Date>();
        Iterator<Worker> it = set.iterator();
        if (set.size() == 0) {
            response = response + "empty collection";
        } else {
            while (it.hasNext()) {
                Worker bum = it.next();
                dates.add(bum.getEndDate());

            }
            Collections.sort(dates);
            for (int i = 0; i < dates.size(); i++) {
                response = response + dates.get(i).toString() + "\r\n";
            }
        }
        clientCaller.sendToClient(transformer.Serialize(response));
    }
}
