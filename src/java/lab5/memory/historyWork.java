package lab5.memory;

import java.util.ArrayList;

public class historyWork {
        private static ArrayList<String> history = new ArrayList<String>();


    public static void historyAdd(String command){
            if (history.size()>4){
                history.remove(0);
            }
            history.add(command);
        }

    public static ArrayList<String> getHistory(){
        return history;
    }
}
