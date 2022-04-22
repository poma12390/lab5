package lab5.client.commands;

import lab5.client.ServerCaller;
import lab5.runners.Worker;

import java.util.List;

public class Show2 {

    public void runCommand(ServerCaller serverCaller){
        List<Worker> bums = serverCaller.getCollection();
        System.out.println(bums);
    }
}