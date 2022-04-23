package lab5.client;
import lab5.common.Worker;
import lab5.common.Transformer;
import lab5.common.dto.AddCommandDto;
import lab5.common.dto.CommandRequestDto;
import lab5.common.dto.WorkerDto;
import lab5.common.exceptions.ServerNotFoundException;
import lab5.server.commands.Commands;

import java.nio.ByteBuffer;

public class ClientRunner {
    public static void main(String[] args) {

        String input = "info";
        Commands.temporaryStart();//типо запустил сервер инициализация всего
        Worker bum = new Worker();
        WorkerDto workerDto = Transformer.WorkerToWorkerDto(bum);
        CommandRequestDto<WorkerDto> commandRequestDto = new CommandRequestDto<>("add", workerDto);
        AddCommandDto add = new AddCommandDto();

        Transformer transformer = new Transformer();
        bum.setName("maaan"); bum.setId(1123);
        byte[] a = new byte[2048];

        WorkerDto man = Transformer.WorkerToWorkerDto(bum);

        add.setBum(man);
        ByteBuffer buf = ByteBuffer.wrap(a);
        buf.put(transformer.Serialize(man));
        byte[] test;
        CommandRequestDto<AddCommandDto> crd = new CommandRequestDto<>("add",add);
        System.out.println(crd.getCommandArgs().getBum().getName());
        test = transformer.Serialize(crd);
        //System.out.println(crd.getCommandArgs().getBum().getName() + " " + crd.getCommandName());

        ServerCaller serverCaller = new ServerCaller();

        try {

            serverCaller.sendToServer(transformer.Serialize(crd));}
        catch (ServerNotFoundException e){
            System.out.println(e.getMessage());
        }


    }
}
