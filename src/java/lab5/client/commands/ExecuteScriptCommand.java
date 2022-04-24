package lab5.client.commands;

import lab5.client.ServerCaller;
import lab5.common.Transformer;
import lab5.common.exceptions.EndStreamException;
import lab5.client.memory.OverflowChecker;

import java.io.*;
import java.util.List;

import static lab5.client.commands.Utils.*;
import static lab5.client.inputters.InputUtils.inputString;

public class ExecuteScriptCommand extends BaseCommand {
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
    protected void Execute(List<String> params, ServerCaller serverCaller, Transformer transformer) {
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
                    Utils.setCurrentBufferedReader(bufferedReader);

                    do {
                        try {
                            String commandWithParameters = inputString("");
                            runCommandFromString(commandWithParameters);
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
            Utils.setIsFileExecuted(oldIsFileExecuted);
            //isFileExecuted = oldIsFileExecuted;
            Utils.setBlockPrompts(false);
           // blockPrompts = false;
            Utils.setCurrentBufferedReader(oldReader);
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
