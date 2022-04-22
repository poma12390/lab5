package lab5.client;

import lab5.common.Worker;
import lab5.server.ServerRunner;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ServerCaller {

    private final ServerRunner serverRunner;
    private final ServerReciever serverReciever;

    {

    }
    public ServerCaller(ServerRunner serverRunner, ServerReciever serverReciever) {
        this.serverRunner = serverRunner;
        this.serverReciever = serverReciever;
    }

    public List<Worker> getCollection(){
       // byte[] request = new byte[10];// Вызвать процедуру упаковки команды getWorkers
        byte[] response = serverReciever.receive("getCollectionCommand".getBytes(StandardCharsets.UTF_8));
        List<Worker> result = new ArrayList<>();// вызвать процедуру распаковки из response в result
        return result;
    }
    public Worker getWorker(){
        byte[] request = new byte[10];
        serverRunner.call("getWorkerCommand".getBytes(StandardCharsets.UTF_8));

        Worker bum = new Worker(); // response -> result
        return null;
    }
    public void send (Object command){

    }

}
