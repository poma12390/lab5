package lab5.client;

import lab5.runners.Worker;
import lab5.server.ServerRunner;

import java.util.ArrayList;
import java.util.List;

public class ServerCaller {
    private final ServerRunner serverRunner;
    private final ServerReciever serverReciever;
    public ServerCaller(ServerRunner serverRunner, ServerReciever serverReciever) {
        this.serverRunner = serverRunner;
        this.serverReciever = serverReciever;
    }

    public List<Worker> getWorkers(){
        byte[] request = new byte[10];// Вызвать процедуру упаковки команды getWorkers
        serverRunner.call(request);
        byte[] response = serverReciever.receive();
        List<Worker> result = new ArrayList<>();// вызвать процедуру распаковки из response в result
        return result;
    }
}
