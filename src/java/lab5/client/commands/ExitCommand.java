package lab5.client.commands;

import lab5.client.ServerCaller;
import lab5.common.Transformer;

import java.util.List;

public class ExitCommand extends BaseCommand

        /**
         * exit command
         * command for exit
         */
{
    @Override
    protected void Execute(List<String> params, ServerCaller serverCaller, Transformer transformer) {
        ParamsChecker.checkParams(0, params);
        System.out.println("bye");
        System.exit(0);
    }
}
