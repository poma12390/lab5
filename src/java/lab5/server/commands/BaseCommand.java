package lab5.server.commands;

import lab5.client.commands.ParamsChecker;
import lab5.client.memory.HistoryWork;
import lab5.common.Worker;
import lab5.common.dto.CommandRequestDto;
import lab5.common.exceptions.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
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

    protected abstract void Execute(CommandRequestDto<? extends Serializable> params, LinkedHashSet<Worker> set) throws IOException, InvalidSalaryException, InvalidDateFormatException, ParseException, InvalidEndDateException;

    public String getName() {
        return name;
    }

    public void ExecuteCommand(CommandRequestDto<? extends Serializable> params, LinkedHashSet<Worker> set) {
        try {
            Execute(params, set);
            HistoryWork.historyAdd(name);
        } catch (InvalidEndDateException | FileNotFoundException | MissedCommandArgumentException | EmptyCollectionException | InvalidSalaryException | InvalidDateFormatException | RecursiveScriptExecuteException e){
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            System.out.println("ошибка парсера");
        }
    }
}