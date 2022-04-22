package lab5.client;

import lab5.runners.Worker;
import lab5.server.ServerRunner;

import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ServerCaller {
    DatagramPacket dp;
    private final int port = 1290;
    private final InetAddress host;
    private final ServerRunner serverRunner;
    private final ServerReciever serverReciever;

    {
        try {
            DatagramSocket  ds = new DatagramSocket();
            host = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            System.out.println("NO HOST");
            throw new RuntimeException(e);
        } catch (SocketException e) {
            System.out.println("Socket exception");
            throw new RuntimeException(e);
        }
    }
    public ServerCaller(ServerRunner serverRunner, ServerReciever serverReciever) {
        this.serverRunner = serverRunner;
        this.serverReciever = serverReciever;
    }

    public List<Worker> getCollection(){
       // byte[] request = new byte[10];// Вызвать процедуру упаковки команды getWorkers
        serverRunner.call("getCollectionCommand".getBytes(StandardCharsets.UTF_8));
        byte[] response = serverReciever.receive();
        List<Worker> result = new ArrayList<>();// вызвать процедуру распаковки из response в result
        return result;
    }
    public Worker getWorker(){
        byte[] request = new byte[10];
        serverRunner.call("getWorkerCommand".getBytes(StandardCharsets.UTF_8));
        byte[] response = serverReciever.receive();
        Worker bum = new Worker(); // response -> result
        return null;
    }

}
