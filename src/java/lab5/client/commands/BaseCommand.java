package lab5.client.commands;

import lab5.client.ServerCaller;
import lab5.common.Transformer;
import lab5.common.exceptions.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public abstract class BaseCommand {

    private static final String SUFFIX = "Command";

    ServerCaller serverCaller = new ServerCaller();
    Transformer transformer = new Transformer();
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

    protected abstract void Execute(List<String> params, ServerCaller serverCaller, Transformer transformer) throws IOException, InvalidSalaryException, InvalidDateFormatException, ParseException, InvalidEndDateException;

    public String getName() {
        return name;
    }

    public void ExecuteCommand(List<String> params) {
        //ParamsChecker.checkParams(getCommandParamsCount(), params);
        try {
            Execute(params, serverCaller, transformer);
        } catch (InvalidEndDateException | FileNotFoundException | MissedCommandArgumentException | EmptyCollectionException | InvalidSalaryException | InvalidDateFormatException | RecursiveScriptExecuteException e){
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            System.out.println("ошибка парсера");
        }
    }
}
