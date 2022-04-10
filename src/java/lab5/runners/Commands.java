package lab5.runners;

import lab5.commands.*;
import lab5.exceptions.*;
import lab5.memory.OverflowChecker;
import lab5.memory.HistoryWork;
import lab5.setterrs.*;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.time.ZonedDateTime;
import java.util.*;

import static lab5.inputters.InputUtils.*;


public class Commands {
    private static ArrayList<Integer> ids = new ArrayList<Integer>();

    private static List<BaseCommand> commands = Arrays.asList(
            new ShowCommand(),
            new ExitCommand(),
            new HelpCommand(),
            new InfoCommand(),
            new AddCommand(),
            new AddIfMinCommand(),
            new ClearCommand(),
            new ExecuteScriptCommand(),
            new FilterBySalaryCommand(),
            new HistoryCommand(),
            new PrintFieldDescendingEndDateCommand(),
            new RemoveLowerCommand(),
            new RemoveByIdCommand(),
            new RemoveAllByEndDateCommand(),
            new SaveCommand(),
            new UpdateIdCommand()
    );

    /**
     * open command
     * @param filename file name
     */
    public static String open(String filename) {
        try (InputStream is = new FileInputStream(filename)) {
            try (BufferedInputStream bis = new BufferedInputStream(is)) {
                ByteArrayOutputStream buf = new ByteArrayOutputStream();
                int result = bis.read();
                while (result != -1) {
                    buf.write((byte) result);
                    result = bis.read();
                }
                System.out.println(buf.toString().replace("\"", ""));
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

    private static Worker upload(String[] sts) throws InvalidDataException, ParseException {
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
                //System.out.println("не вайлидый файл");
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
     * updateAll command
     * @param bum Woker to update it's stats
     */

    public static void updateAll(Worker bum) throws IOException {
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
                a = false;
            }
            else {
                System.out.println("salary must be =>0");
            }
        }
        cord.setXY(x, y);
        bum.setCoordinates(cord);

        Date startDate = inputData("(date) start date");
        bum.setStartDate(startDate);
        a = true;
        while (a){
            Date endDate = inputData("(date) end date");
            if (endDate.compareTo(bum.getStartDate())<=0){
                System.out.println("start date should be < enddate");
            }
            else{
                bum.setEndDate(endDate);
                a = false;
            }
        }



        Person pers = new Person();
        ZonedDateTime birthday = inputZonedDate("(date) birthday");
        pers.setBirthday(birthday);

        Float height = inputFloat("(float) height");
        pers.setHeight(height);
        Float weight = inputFloat("(float) weight");
        pers.setWeight(weight);

        bum.setPerson(pers);

        a = true;

        while (a) {
            System.out.print("write position: (BAKER, LABORER, DIRECTOR, MANAGER,ENGINEER)");
            input = bufferedReader.readLine();
            try {
                SetPosition.setPosition(input, bum);
                a = false;

            }
            catch (NullPointerException | NoSuchElementException e) {
                funExit();
            }catch (Exception e) {
                System.out.println(" No such enum");
            }

        }

    }



    public static Worker makeId(Worker bum) {
        bum.setId(ids.size() + 1);
        ids.add(ids.size() + 1);
        return bum;
    }

    static boolean test = true;
    public static void runCommandFromString(LinkedHashSet<Worker> workers, String input) {

        try {
            test = false;
            String[] items = input.split(" ");
            String cmd = items[0].toLowerCase();
            List<String> params = new ArrayList<>();
            for (int i = 1; i < items.length; i++) {
                params.add(items[i]);
            }

            //runCommand(workers, cmd, params);
            runCommand2(workers, cmd, params);
            if (!test){
                System.out.println("no such method");
            }
        } catch (NullPointerException | NoSuchElementException e) {
            funExit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Deprecated
    private static void runCommand(LinkedHashSet<Worker> workers, String commandName, List<String> commandParams) {
        try {
            Method method = Commands.class.getMethod(commandName, List.class, LinkedHashSet.class);
            method.invoke(null, commandParams, workers);
            HistoryWork.historyAdd(commandName);
        } catch (InvocationTargetException e) {
            HistoryWork.historyAdd(commandName);
            System.out.println(e.getCause().getMessage());
        } catch (NoSuchMethodException e) {
            System.out.println("no such command");
        } catch (NullPointerException | NoSuchElementException e){
            funExit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void runCommand2(LinkedHashSet<Worker> workers, String commandName, List<String> commandParams) {
        for (BaseCommand command: commands) {
            if (command.getName().equalsIgnoreCase(commandName)) {
                try {
                    command.ExecuteCommand(commandParams, workers);
                    test = true;
                }catch (MissedCommandArgumentException e) {
                    System.out.println(e.getMessage());

                } catch (Exception e) {
                    e.printStackTrace();
                }
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
