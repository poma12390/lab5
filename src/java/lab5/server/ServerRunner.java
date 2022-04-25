package lab5.server;


public class ServerRunner {

    public static void main(String[] args) {


        // TODO: Запустить чтение датаграммов с клиента

        new Thread(() -> {

            // выполнение в отдельном потоке

        }).start();



        System.out.println("Нажмите Ctrl+C для закрытия сервера");
        // TODO: ждать CTRL+C

        // TODO: после Ctrl+C вызвать сохранение коллекции



        ClientReceiver receiver = new ClientReceiver();
        receiver.run();
    }

}
