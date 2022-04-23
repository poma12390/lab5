package lab5.server;

public class ServerRunner {

    public static void main(String[] args) {
        // TODO: Запустить чтение датаграммов с клиента

        ClientReceiver receiver = new ClientReceiver();
        receiver.run();
    }

}
