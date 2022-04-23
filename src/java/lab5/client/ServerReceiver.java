package lab5.client;

import lab5.exceptions.ServerNotFoundException;

import java.io.IOException;

public class ServerReceiver {

    private final ServerCaller serverReceiver;

    public ServerReceiver(ServerCaller serverReceiver) {
        this.serverReceiver = serverReceiver;
    }

//    public List<Worker> getCollection(){
//       // byte[] request = new byte[10];// Вызвать процедуру упаковки команды getWorkers
//        byte[] response = serverReciever.receive("getCollectionCommand".getBytes(StandardCharsets.UTF_8));
//        List<Worker> result = new ArrayList<>();// вызвать процедуру распаковки из response в result
//        return result;
//    }
//    public Worker getWorker(){
//        byte[] request = new byte[10];
//        serverRunner.call("getWorkerCommand".getBytes(StandardCharsets.UTF_8));
//
//        Worker bum = new Worker(); // response -> result
//        return null;
//    }
//    public void send (Object command){
//
//    }



//    private byte[] catcher(){
//        try {
//            dc.configureBlocking(false);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        if (buf1 != null){
//            buf1.clear();
//        }
//        for (int i =0; i<5; i++) {
//            sleep(1000);
//
//            try {
//                addr = dc.receive(buf);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            if (addr != null){
//                break;
//            }
//            if (i <4){
//                System.out.println("Trying to connect to server");
//            }
//            else throw new ServerNotFoundException();
//        }
//
//        return null;
//    }

    private void sleep(int mils){
        try {
            Thread.sleep(mils);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
