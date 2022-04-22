package lab5.commands;

import lab5.runners.ParamsChecker;
import lab5.common.Worker;

import java.util.LinkedHashSet;
import java.util.List;


public class HelpCommand extends BaseCommand{
    /**
     * help command
     * show all commands
     */

    @Override
    protected void Execute(List<String> params, LinkedHashSet<Worker> set) {
        ParamsChecker.checkParams(0, params);
        System.out.println("help : вывести справку по доступным командам\n" +
                "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
                "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                "add {element} : добавить новый элемент в коллекцию\n" +
                "update id {element} : обновить значение элемента коллекции, id которого равен заданному\n" +
                "remove_by_id id : удалить элемент из коллекции по его id\n" +
                "clear : очистить коллекцию\n" +
                "save : сохранить коллекцию в файл\n" +
                "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
                "exit : завершить программу (без сохранения в файл)\n" +
                "add_if_min {element} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции\n" +
                "remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный\n" +
                "history : вывести последние 5 команд (без их аргументов)\n" +
                "remove_all_by_end_date endDate : удалить из коллекции все элементы, значение поля endDate которого эквивалентно заданному\n" +
                "filter_by_salary salary : вывести элементы, значение поля salary которых равно заданному\n" +
                "print_field_descending_end_date : вывести значения поля endDate всех элементов в порядке убывания");
    }
}
