package lab5.commands;

import lab5.memory.HistoryWork;
import lab5.runners.ParamsChecker;
import lab5.common.Worker;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class HistoryCommand extends BaseCommand{
    /**
     * history command
     * show last 5 commands without params
     */


    @Override
    protected void Execute(List<String> params, LinkedHashSet<Worker> set) {
        ParamsChecker.checkParams(0, params);
        ArrayList<String> history = HistoryWork.getHistory();
        if (history.size() == 0) {
            System.out.print("cant be first command");
        } else {
            for (String s : history) {
                System.out.print(s + " ");
            }
        }
        System.out.println("");
    }
}
