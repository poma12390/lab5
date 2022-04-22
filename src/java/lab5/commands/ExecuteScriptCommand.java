package lab5.commands;

import lab5.exceptions.EndStreamException;
import lab5.memory.OverflowChecker;
import lab5.runners.Commands;
import lab5.runners.ParamsChecker;
import lab5.common.Worker;

import java.io.*;
import java.util.LinkedHashSet;
import java.util.List;

import static lab5.inputters.InputUtils.inputString;
import static lab5.runners.Commands.*;

public class ExecuteScriptCommand extends BaseCommand{
    @Override
    public String getName() {
        return "execute_script";
    }

    @Override
    protected int getCommandParamsCount() {
        return 1;
    }
    /**
     * executeScript command
     * @param params filename to complete script
     * run all commands from file
     */
    @Override
    protected void Execute(List<String> params, LinkedHashSet<Worker> set) {
        ParamsChecker.checkParams(1, params);

        String fileName = params.get(0);

        if (!isFileExecuted)
            OverflowChecker.getFiles().clear();

        OverflowChecker.checkRec(fileName);

        BufferedReader oldReader = currentBufferedReader;
        blockPrompts = true;
        boolean oldIsFileExecuted = isFileExecuted;
        isFileExecuted = true;
        try {

            try {
                try(InputStream fileInputStream = new FileInputStream(fileName)) {
                    InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    Commands.setCurrentBufferedReader(bufferedReader);

                    do {
                        try {
                            String commandWithParameters = inputString("");
                            runCommandFromString(set, commandWithParameters);
                        } catch (EndStreamException e) {
                            break;
                        }
                    } while (true);

                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } finally {
            Commands.setIsFileExecuted(oldIsFileExecuted);
            //isFileExecuted = oldIsFileExecuted;
            Commands.setBlockPrompts(false);
           // blockPrompts = false;
            Commands.setCurrentBufferedReader(oldReader);
        }
//        String s = "";
//        ParamsChecker.checkParams(1, params);
//        s = Commands.open(params.get(0));
//        if (s.isEmpty()) {
//            return;
//        }
//        OverflowChecker.checkRec(params.get(0));
//        String[] commands = s.split("\r\n");
//        for (int i = 0; i < commands.length; i++) {
//            String command = commands[i];
//            System.out.println("doing " + command);
//            Commands.runCommandFromString(set, command);
//        }

    }
}
