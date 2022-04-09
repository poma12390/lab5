package lab5.runners;

import lab5.commands.BaseCommand;
import lab5.commands.ExitCommand;
import lab5.commands.ShowCommand;
import lab5.exceptions.*;
import lab5.inputters.*;
import lab5.memory.OverflowChecker;
import lab5.memory.historyWork;
import lab5.setterrs.*;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static lab5.inputters.InputUtils.*;


public class Commands {
    private static ArrayList<Integer> ids = new ArrayList<Integer>();

    private static List<BaseCommand> commands = Arrays.asList(
            new ShowCommand(),
            new ExitCommand()
    );

    /**
     * open command
     * @param filename file name
     */
    protected static String open(String filename) {
        try (InputStream is = new FileInputStream(filename)) {
            try (BufferedInputStream bis = new BufferedInputStream(is)) {
                ByteArrayOutputStream buf = new ByteArrayOutputStream();
                int result = bis.read();
                while (result != -1) {
                    buf.write((byte) result);
                    result = bis.read();
                }
                return buf.toString().replace("\"", "");
            } catch (Exception e) {

                if (e.getMessage().isEmpty()){
                    System.out.println(e.getCause().getMessage());
                }
                else {
                    System.out.println(e.getMessage());
                }

                return "";
            }
        } catch (Exception e) {
            //System.out.println("s");
            if (e.getMessage().isEmpty()){
                System.out.println(e.getCause().getMessage());
            }
            else {
                System.out.println(e.getMessage());
            }
            return ""; // ?????????
        }
    }

    /**
     * upload command
     * @param sts stats to upload bum
     * @return Worker
     */

    protected static Worker upload(String[] sts) throws InvalidDataException, ParseException {
        Worker bum = new Worker();
        try {
            String name = sts[0].trim();
            SetName.setname(name, bum);
            String x = sts[1].trim();
            String y = sts[2].trim();
            SetCordinates.setcordinates(x, y, bum);

            String salary = sts[3].trim();
            SetSalary.setSalary(salary, bum);
            String startDate = sts[4].trim();
            SetData.setStartData(startDate, bum);
            String endDate = sts[5].trim();
            SetData.setEndData(endDate, bum);
            String birthday = sts[6].trim();
            Person person = new Person();
            SetPersParams.setBirthday(birthday, person);
            String height = sts[7].trim();
            SetPersParams.setHeight(height, person);
            String weight = sts[8].trim();
            SetPersParams.setWeight(weight, person);
            bum.setPerson(person);
            String pos = sts[9].trim();
            SetPosition.setPosition(pos, bum);
        }
        catch (Exception e){
            System.out.println("не корректный csv файл, один из элементов не установлен");
        }


        return bum;
    }

    /**
     * help command
     * show all commands
     */


    public static void help(List<String> params, LinkedHashSet<Worker> set) {
        ParamsChecker.checkParams(0, params);
        System.out.println(open("Commands.txt"));
    }


    /**
     * begin command
     * create new Worker from file
     */

    public static void begin(String start, LinkedHashSet<Worker> set) {
        Worker worker = new Worker();
        String[] str = start.split("\r\n");
        for (int i = 1; i < str.length; i++) {
            String[] stats = str[i].split(";");
            try {
                worker = Commands.upload(stats);
                if (worker.getPosition() == null){
                    throw new EmptyCollectionException();
                }
                worker = makeId(worker);
                set.add(worker);
            } catch (InvalidDataException | ParseException e) {
                System.out.println(e.getMessage());
            }catch (EmptyCollectionException e){
                System.out.println("не вайлидый файл");
            }
        }

    }

    /**
     * id getter
     */

    public static ArrayList<Integer> getIds() {
        return ids;
    }

    /**
     * exit command
     * command for exit
     */

    public static void exit(List<String> params, LinkedHashSet<Worker> set) {
        ParamsChecker.checkParams(0, params);
        System.out.println("bye");
        System.exit(0);
    }

    /**
     * info command
     * command to show info aд
     */

    public static void info(List<String> params, LinkedHashSet<Worker> set) {
        ParamsChecker.checkParams(0, params);
        Iterator<Worker> it = set.iterator();
        Worker p1 = it.next();
        System.out.println("Type - Worker");
        System.out.println("Created date - " + p1.getCreationDate());
    }

    /**
     * updateAll command
     * @param bum Woker to update it's stats
     */

    private static void updateAll(Worker bum) throws IOException {
        InputStream inputStream = System.in;
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        boolean c;
        String input = "";
        while (input.isEmpty()) {
            System.out.print("write name: ");
            input = bufferedReader.readLine().trim();
            if (input.isEmpty()) {
                System.out.println("try again string is empty ");
            }

        }
        bum.setName(input);
        Coordinates cord = new Coordinates();
        long x = inputLong("(int) x");
        int y = inputInt("(long) y");

        boolean a = true;
        while (a) {
            Float salary = inputFloat("(float) salary");
            if (salary > 0) {
                bum.setSalary(salary);
            }
            else {
                System.out.println("salary must be =>0");
            }
        }
        cord.setXY(x, y);
        bum.setCoordinates(cord);

        Date startDate = inputData("(date) start date");
        bum.setStartDate(startDate);
        Date endDate = inputData("(date) end date");
        bum.setEndDate(endDate);

        Person pers = new Person();
        ZonedDateTime birthday = inputZonedDate("(date) birthday");
        pers.setBirthday(birthday);

        Float height = inputFloat("(float) height");
        pers.setHeight(height);
        Float weight = inputFloat("(float) weight");
        pers.setWeight(weight);

        bum.setPerson(pers);

        boolean c1 = true;

        while (c1) {
            System.out.print("write position: (BAKER, LABORER, DIRECTOR, MANAGER,ENGINEER)");
            input = bufferedReader.readLine();
            try {
                SetPosition.setPosition(input, bum);
                c1 = false;

            }
            catch (NullPointerException | NoSuchElementException e) {
                funExit();
            }catch (Exception e) {
                System.out.println(" No such enum");
            }

        }

    }

    /**
     * add command
     * add new Worker and set stats
     * */

    public static void add(List<String> params, LinkedHashSet<Worker> set) throws IOException {
        ParamsChecker.checkParams(0, params);
        Worker bum = new Worker();

        updateAll(bum);
        bum = makeId(bum);
        set.add(bum);
    }


    /**
     * show command
     * show all obj from in Collection
     */

    public static void show(List<String> params, LinkedHashSet<Worker> set) throws EmptyCollectionException {
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
    }

    /**
     * update command
     * @param params id Worker to update
     * update oall stats
     */

    public static void update(List<String> params, LinkedHashSet<Worker> set) throws IOException {
        ParamsChecker.checkParams(1, params);
        Iterator<Worker> it = set.iterator();
        while (it.hasNext()) {
            Worker bum = it.next();
            Integer s = null;
            String v;
            s = bum.getId();
            v = Integer.toString(s);
            if (v.equals(params.get(0))) {
                updateAll(bum);
                return;
            }
        }
    }

    /**
     * history command
     * show last 5 commands without params
     */

    public static void history(List<String> params, LinkedHashSet<Worker> set) {
        ParamsChecker.checkParams(0, params);
        ArrayList<String> history = historyWork.getHistory();
        if (history.size() == 0) {
            System.out.print("cant be first command");
        } else {
            for (String s : history) {
                System.out.print(s + " ");
            }
        }
        System.out.println("");
    }

    /**
     * addIfMin command
     * add new Worker if it's min in coll
     */

    public static void add_if_min(List<String> params, LinkedHashSet<Worker> set) throws IOException {
        ParamsChecker.checkParams(0, params);
        Worker bum = new Worker();
        updateAll(bum);
        if (set.size() == 0) {
            bum = makeId(bum);
            set.add(bum);
        } else {


            Worker min = Collections.min(set);
            if (bum.compareTo(min) > 0) {
                bum = makeId(bum);
                set.add(bum);
                System.out.println("success");
            } else {
                System.out.println("not min element");
            }
        }
    }

    /**
     * removeById command
     * @param params id of worker to delete
     * delete worker from collections with id
     */

    public static void remove_by_id(List<String> params, LinkedHashSet<Worker> set) {
        ParamsChecker.checkParams(1, params);
        Iterator<Worker> it = set.iterator();
        while (it.hasNext()) {
            Worker bum = it.next();
            Integer s = null;
            String v;
            s = bum.getId();
            v = Integer.toString(s);
            System.out.println(v);
            if (v.equals(params.get(0))) {
                set.remove(bum);
                return;
            }
        }
    }

    /**
     * clear command
     * clear collection
     */

    public static void clear(List<String> params, LinkedHashSet<Worker> set) {
        ParamsChecker.checkParams(0, params);
        set.clear();
    }

    private static Worker makeId(Worker bum) {
        bum.setId(ids.size() + 1);
        ids.add(ids.size() + 1);
        return bum;
    }

    /**
     * save command
     * save collection in csv file
     */

    public static void save(List<String> params, LinkedHashSet<Worker> set) throws IOException {
        OutputStream outputStream = new FileOutputStream("save.csv");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        outputStreamWriter.write("name;x;y;salary;startDate;endDate;birthday;height;weight;position\r\n");
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

    /**
     * removeLower command
     * remove lower element from collection
     */

    public static void remove_lower(List<String> params, LinkedHashSet<Worker> set) throws EmptyCollectionException {
        ParamsChecker.checkParams(0, params);
        if (set.size() == 0) {
            throw new EmptyCollectionException();
        }
        Worker min = Collections.min(set);
        set.remove(min);
    }

    /**
     * removeByEndDate command
     * @param params end date to delete elements with
     * delete elemets with input end date
     */

    public static void remove_all_by_end_date(List<String> params, LinkedHashSet<Worker> set) throws InvalidDateFormatException, ParseException {
        ParamsChecker.checkParams(1, params);
        String input = params.get(0);
        Iterator<Worker> it = set.iterator();
        Worker test = new Worker();
        try {
            SetData.setEndData(input, test);
            while (it.hasNext()) {
                Worker bum = it.next();
                if (bum.getEndDate().compareTo(test.getEndDate()) == 0) {
                    System.out.println("remove " + bum.getName());
                    set.remove(bum);
                    return;
                }
            }
            System.out.println("no equals data");
        } catch (InvalidDateFormatException e) {
            System.out.println(e.getMessage());
        } catch (ParseException e) {
            System.out.println("ошибка парсера");
        }
    }

    /**
     * FilterBySalary command
     * show elements sorted by salary
     */

    public static void filter_by_salary(List<String> params, LinkedHashSet<Worker> set) throws InvalidSalaryException {
        ParamsChecker.checkParams(1, params);
        String salary = params.get(0);
        Iterator<Worker> it = set.iterator();
        Worker test = new Worker();
        try {
            SetSalary.setSalary(salary, test);
            while (it.hasNext()) {
                Worker bum = it.next();
                if (bum.getSalary() == test.getSalary()) {
                    System.out.println(bum.toString());
                    System.out.println("чел " + bum.getId() + " " + bum.getName() + " зарабатывает " + bum.getSalary());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * printFieldDescendingDate command
     * show sorted endDate
     */

    public static void print_field_descending_end_date(List<String> params, LinkedHashSet<Worker> set) {
        ParamsChecker.checkParams(0, params);
        List<Date> dates = new ArrayList<Date>();
        Iterator<Worker> it = set.iterator();
        while (it.hasNext()) {
            Worker bum = it.next();
            dates.add(bum.getEndDate());

        }
        Collections.sort(dates);
        for (int i = 0; i < dates.size(); i++) {
            System.out.println(dates.get(i));
        }
    }


    /**
     * executeScript command
     * @param params filename to complete script
     * run all commands from file
     */


    public static void execute_script(List<String> params, LinkedHashSet<Worker> set) throws IOException {
        String s = "";
        ParamsChecker.checkParams(1, params);
        s = open(params.get(0));
        if (s.isEmpty()) {
            return;
        }
        OverflowChecker.checkRec(params.get(0));
        String[] commands = s.split("\r\n");
        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            System.out.println("doing " + command);
            runCommandFromString(set, command);
        }
    }

    static void runCommandFromString(LinkedHashSet<Worker> workers, String input) {
        try {
            String[] items = input.split(" ");
            String cmd = items[0].toLowerCase();
            List<String> params = new ArrayList<>();
            for (int i = 1; i < items.length; i++) {
                params.add(items[i]);
            }

            //runCommand(workers, cmd, params);
            runCommand2(workers, cmd, params);
        } catch (NullPointerException | NoSuchElementException e) {
            funExit();
        }
    }

    @Deprecated
    private static void runCommand(LinkedHashSet<Worker> workers, String commandName, List<String> commandParams) {
        try {
            Method method = Commands.class.getMethod(commandName, List.class, LinkedHashSet.class);
            method.invoke(null, commandParams, workers);
            historyWork.historyAdd(commandName);
        } catch (InvocationTargetException e) {
            historyWork.historyAdd(commandName);
            System.out.println(e.getCause().getMessage());
        } catch (NoSuchMethodException e) {
            System.out.println("no such command");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }catch (NullPointerException | NoSuchElementException e){
            funExit();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void runCommand2(LinkedHashSet<Worker> workers, String commandName, List<String> commandParams) {
        for (BaseCommand command: commands) {
            if (command.getName().equalsIgnoreCase(commandName)) {

                try {
                    command.ExecuteCommand(commandParams, workers);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                return;
            }
        }
    }

    public static void funExit(){
        System.out.println("для выхода я написал комманду exit");
        System.out.println(" +\"\"\"\"\"+ ");
        System.out.println("[| o o |]");
        System.out.println(" |  ^  | ");
        System.out.println(" | '-' | ");
        System.out.println(" +-----+ ");
        System.exit(1);
    }

}
