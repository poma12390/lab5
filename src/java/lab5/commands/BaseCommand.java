package lab5.commands;

import lab5.runners.ParamsChecker;
import lab5.runners.Worker;

import java.util.LinkedHashSet;
import java.util.List;

public abstract class BaseCommand {

    private static final String SUFFIX = "Command";

    private final String name;

    public BaseCommand() {
        String simpleName = this.getClass().getSimpleName();

        assert simpleName.endsWith(SUFFIX);

        this.name = simpleName.substring(0, simpleName.length() - SUFFIX.length());
    }

    /**
     * Определить количество параметрво, необходимых для данной команды.
     * Переопределяется в командах-наследниках, у которых количество параметров отличается от дефолтного
     * @return по умолчанию возвращает 0 (команда без параметров)
     */
    protected int getCommandParamsCount() {
        return 0;
    }

    protected abstract void Execute(List<String> params, LinkedHashSet<Worker> set);

    public String getName() {
        return name;
    }

    public void ExecuteCommand(List<String> params, LinkedHashSet<Worker> set) {
        ParamsChecker.checkParams(getCommandParamsCount(), params);
        Execute(params, set);
    }
}
