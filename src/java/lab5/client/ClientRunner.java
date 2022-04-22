package lab5.client;

import lab5.client.commands.Show2;
import lab5.server.ServerRunner;

import java.net.*;

public class ClientRunner {
    public static void main(String[] args) {

        ServerRunner server = new ServerRunner();
        ServerReciever serverReciever = new ServerReciever();
        ServerCaller serverCaller = new ServerCaller(server,serverReciever);
        Show2 show2 = new Show2();
        show2.runCommand(serverCaller);

    }
}
