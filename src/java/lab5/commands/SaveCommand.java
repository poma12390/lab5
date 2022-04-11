package lab5.commands;

import lab5.runners.ParamsChecker;
import lab5.runners.Worker;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class SaveCommand extends BaseCommand{

    /**
     * save command
     * save collection in csv file
     */

    @Override
    protected void Execute(List<String> params, LinkedHashSet<Worker> set) throws IOException {
        OutputStream outputStream = new FileOutputStream("save.csv");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        outputStreamWriter.write("name;x;y;salary;startDate;endDate;birthday;height;weight;position;id;creationDate\r\n");
        ParamsChecker.checkParams(0, params);
        Iterator<Worker> it1 = set.iterator();
        String pattern = "dd.MM.yyyy";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        DateFormat df = new SimpleDateFormat(pattern);
        while (it1.hasNext()) {
            Worker bum = it1.next();
            System.out.println(bum.toString());
            outputStreamWriter.write(bum.toString());
            //outputStreamWriter.write((bum.getName()+";"+Long.toString(bum.getCoordinates().getX())+";"+Integer.toString(bum.getCoordinates().getY())+";"+Float.toString(bum.getSalary())+";"+df.format(bum.getStartDate())+";"+df.format(bum.getEndDate())+";"+bum.getPerson().getBirthday().format(formatter)+";"+Float.toString(bum.getPerson().getHeight())+";"+Float.toString(bum.getPerson().getWeight())+";"+bum.getPosition().toString())+"\r\n");
        }
        outputStreamWriter.close();
    }
}
