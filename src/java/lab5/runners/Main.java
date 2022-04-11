package lab5.runners;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        LinkedHashSet<Worker> set = new LinkedHashSet<>();
        String start = Commands.open("C:\\Users\\pomat\\IdeaProjects\\lab5\\save.csv");
        String env = System.getenv("Javahome");
        System.out.println(env + " env");
        // String start = Commands.open(System.getenv("Javahome"));
        Commands.begin(start, set);


        InputStream inputStream = System.in;
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        Commands.setCurrentBufferedReader(bufferedReader);
        try{
        while (true) {
            System.out.print("Write a command: ");
            String input = bufferedReader.readLine();
            Commands.runCommandFromString(set, input.trim());}
        }
        catch (NullPointerException | NoSuchElementException e){
            Commands.funExit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}

