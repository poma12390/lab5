package lab5.server;

import lab5.client.ServerReceiver;

public class ClientCaller {
    public void sendToClient(byte[] test) {
        ServerReceiver serverReceiver = new ServerReceiver();
        serverReceiver.requestFromServer(test);

    }
}
