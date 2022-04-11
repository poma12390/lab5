package lab5.commands;

import lab5.exceptions.EmptyCollectionException;
import lab5.runners.Commands;
import lab5.runners.ParamsChecker;
import lab5.runners.Worker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class ShowCommand extends BaseCommand {

    /**
     * show command
     * show all obj from in Collection
     */

    @Override
    protected void Execute(List<String> params, LinkedHashSet<Worker> set) {
            ParamsChecker.checkParams(0, params);
            if (set.size() == 0) {
                throw new EmptyCollectionException();
            }
            Iterator<Worker> it1 = set.iterator();
            String pattern = "dd.MM.yyyy";
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            DateFormat df = new SimpleDateFormat(pattern);
            while (it1.hasNext()) {
                Worker bum = it1.next();
                System.out.println(bum.toString());
                //outputStreamWriter.write((bum.getName()+";"+Long.toString(bum.getCoordinates().getX())+";"+Integer.toString(bum.getCoordinates().getY())+";"+Float.toString(bum.getSalary())+";"+df.format(bum.getStartDate())+";"+df.format(bum.getEndDate())+";"+bum.getPerson().getBirthday().format(formatter)+";"+Float.toString(bum.getPerson().getHeight())+";"+Float.toString(bum.getPerson().getWeight())+";"+bum.getPosition().toString())+"\r\n");
            }
            //Commands.show(params, set);

    }
}
