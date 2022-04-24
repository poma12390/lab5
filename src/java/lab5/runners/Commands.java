package lab5.runners;

import lab5.commands.*;
import lab5.common.Coordinates;
import lab5.common.Person;
import lab5.common.Position;
import lab5.common.Worker;
import lab5.common.exceptions.*;
import lab5.client.memory.HistoryWork;
import lab5.setterrs.*;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.time.ZonedDateTime;
import java.util.*;

import static lab5.client.inputters.InputUtils.*;


public class Commands {
    private static ArrayList<Integer> ids = new ArrayList<Integer>();

    public static BufferedReader currentBufferedReader;

    public static boolean blockPrompts = false;

    public static void setBlockPrompts(boolean blockPrompts) {
        Commands.blockPrompts = blockPrompts;
    }

    public static void setIsFileExecuted(boolean isFileExecuted) {
        Commands.isFileExecuted = isFileExecuted;
    }

    public static boolean isFileExecuted = false;

    public static void setCurrentBufferedReader(BufferedReader currentBufferedReader) {
        Commands.currentBufferedReader = currentBufferedReader;
    }
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
            String id = sts[10].trim();
            SetId.setId(id,bum);
            String crdate = sts[11].trim();
            SetData.setCreationData(crdate,bum);
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
                set.add(worker);
            } catch (InvalidDataException | ParseException e) {
                System.out.println(e.getMessage());
            }catch (EmptyCollectionException e){
                System.out.println("не вайлидый файл");
            }catch (Exception e){
                System.out.println("не корректный csv файл, один из элементов не установлен");
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

    public static void updateAll(Worker bum) {

        String input = inputString("(string) name");
        bum.setName(input);

        Coordinates cord = new Coordinates();
        long x = inputLong("(int) x");
        int y = inputInt("(long) y");

        Float salary = inputFloat("(float) salary");
        bum.setSalary(salary);
        cord.setXY(x, y);
        bum.setCoordinates(cord);

        Date startDate = inputData("(date) start date");
        bum.setStartDate(startDate);
        Date endDate;
        do {
            endDate = inputData("(date) end date > start date");
            bum.setEndDate(endDate);
        } while (startDate.after(endDate) | startDate.compareTo(endDate)==0);

        Person pers = new Person();
        ZonedDateTime birthday = inputZonedDate("(date) birthday");
        pers.setBirthday(birthday);

        Float height = inputFloat("(float) height");
        pers.setHeight(height);
        Float weight = inputFloat("(float) weight");
        pers.setWeight(weight);

        bum.setPerson(pers);

        bum.setPosition(inputPosition(
                new StringJoiner(",")
                        .add(Position.BAKER.toString())
                        .add(Position.DIRECTOR.toString())
                        .add(Position.ENGINEER.toString())
                        .add(Position.LABORER.toString())
                        .add(Position.MANAGER.toString())
                        .toString()
        ));
        bum.setCreationDate(new Date());
    }



    public static Worker makeId(Worker bum) {
        Collections.sort(ids);
        for (int i =1; i<ids.size()+2; i++){
            if (!ids.contains(i)){
                bum.setId(i);
                ids.add(i);
                break;
            }
        }
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

                }catch (EndStreamException ignored){

                }
                catch (Exception e) {
                    System.out.println("sd");
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
