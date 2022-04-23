package lab5.client;
import lab5.common.Worker;
import lab5.common.Refactor;
import lab5.common.dto.WorkerDto;
import lab5.exceptions.ServerNotFoundException;
import lab5.server.ServerRunner;

import java.nio.ByteBuffer;

public class ClientRunner {
    public static void main(String[] args) {
        ServerRunner server = new ServerRunner();
        ServerReciever serverReciever = new ServerReciever();
        ServerCaller serverCaller = new ServerCaller(server,serverReciever);
        Refactor refactor = new Refactor();
        Worker bum = new Worker();
        bum.setName("maaan"); bum.setId(1123);
        byte[] a = new byte[2048];



        WorkerDto man = Refactor.WorkerToWorkerDto(bum);
        ByteBuffer buf = ByteBuffer.wrap(a);
        buf.put(refactor.Serialize(man));
        byte[] test;
        test = refactor.Serialize(man);
        Object test1 = refactor.DeSerialize(test);
        if (test1.getClass() == man.getClass()){
            System.out.println("whee");
        }

        String input = "";
        try {

            serverReciever.receive(test);}
        catch (ServerNotFoundException e){
            System.out.println(e.getMessage());
        }


    }
}
