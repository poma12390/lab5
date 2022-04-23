package lab5.server;

import lab5.common.Worker;

import java.util.LinkedHashSet;

public class ServerRunner {

    public static void main(String[] args) {


        // TODO: Запустить чтение датаграммов с клиента

        new Thread(() -> {

            // выполнение в отдельном потоке

        }).start();




        ClientReceiver receiver = new ClientReceiver();
        receiver.run();
    }

}
