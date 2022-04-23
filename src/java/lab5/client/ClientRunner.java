package lab5.client;
import lab5.common.Worker;
import lab5.common.Transformer;
import lab5.common.dto.CommandRequestDto;
import lab5.common.dto.WorkerDto;
import lab5.exceptions.ServerNotFoundException;

import java.nio.ByteBuffer;

public class ClientRunner {
    public static void main(String[] args) {


        Worker bum = new Worker();
        WorkerDto workerDto = Transformer.WorkerToWorkerDto(bum);
        CommandRequestDto<WorkerDto> commandRequestDto = new CommandRequestDto<>("add", workerDto);






        new Thread(() -> {

            // выполнение в отдельном потоке

        }).start();









        Transformer transformer = new Transformer();
        bum.setName("maaan"); bum.setId(1123);
        byte[] a = new byte[2048];



        WorkerDto man = Transformer.WorkerToWorkerDto(bum);
        ByteBuffer buf = ByteBuffer.wrap(a);
        buf.put(transformer.Serialize(man));
        byte[] test;
        test = transformer.Serialize(man);
        Object test1 = transformer.DeSerialize(test);
        if (test1.getClass() == man.getClass()){
            System.out.println("whee");
        }


        ServerCaller serverCaller = new ServerCaller();

        String input = "";
        try {

            serverCaller.sendToServer(test);}
        catch (ServerNotFoundException e){
            System.out.println(e.getMessage());
        }


    }
}
