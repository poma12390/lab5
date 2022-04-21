package lab5.server.commands;

import lab5.runners.Worker;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

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
