package lab5.server.commands;

import lab5.client.commands.ParamsChecker;
import lab5.common.Transformer;
import lab5.common.Worker;
import lab5.common.dto.CommandRequestDto;
import lab5.common.exceptions.EmptyCollectionException;
import lab5.server.ClientCaller;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class InfoCommand extends BaseCommand {
    /**
     * info command
     * command to show info aд
     */

    @Override
    protected void Execute(CommandRequestDto<? extends Serializable> params, LinkedHashSet<Worker> set, Transformer transformer, ClientCaller clientCaller) {
        String response = "";
        int size = (int) set.stream().count();
        if (size == 0){
            response = response + "empty collection";
        }
        else{
            Iterator<Worker> it = set.iterator();
            Worker p1 = it.next();
            response = response + "Type - Worker \r\n";
            response = response + "Created date - " + p1.getCreationDate();
        }
        clientCaller.sendToClient(transformer.Serialize(response));
    }
}
