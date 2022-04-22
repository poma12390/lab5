package lab5.server.commands;

import lab5.common.Worker;

import java.util.LinkedHashSet;

public class utils {
    LinkedHashSet<Worker> set = new LinkedHashSet<>();

    public LinkedHashSet<Worker> getSet() {
        return set;
    }
    /**
     * util command
     * show all commands
     */

    public int util(byte code){
        return set.size();
    }
}
