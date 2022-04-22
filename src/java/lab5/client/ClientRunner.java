package lab5.client;
import lab5.exceptions.ServerNotFoundException;
import lab5.server.ServerRunner;

import java.net.*;
import java.nio.charset.StandardCharsets;

public class ClientRunner {
    public static void main(String[] args) {

        ServerRunner server = new ServerRunner();
        ServerReciever serverReciever = new ServerReciever();
        ServerCaller serverCaller = new ServerCaller(server,serverReciever);
        String input = "";
        try {
        serverReciever.receive(input.getBytes(StandardCharsets.UTF_8));}
        catch (ServerNotFoundException e){
            System.out.println(e.getMessage());
        }


    }
}
