package lab5.client.commands;

import lab5.client.ServerCaller;
import lab5.runners.Worker;
import lab5.server.ServerRunner;

import java.util.List;

public class Show2 {

    public void runCommand(ServerCaller serverCaller){
        List<Worker> bums = serverCaller.getWorkers();
        System.out.println(bums);
    }
}
