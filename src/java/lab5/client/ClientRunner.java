package lab5.client;

import lab5.client.commands.Utils;
import lab5.common.Transformer;
import lab5.common.Worker;
import lab5.common.dto.AddCommandDto;
import lab5.common.dto.CommandRequestDto;
import lab5.common.dto.WorkerDto;
import lab5.server.commands.Commands;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.util.NoSuchElementException;

public class ClientRunner {
    public static void main(String[] args) {

        InputStream inputStream = System.in;
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        Utils.setCurrentBufferedReader(bufferedReader);


        Commands.temporaryStart();//типо запустил сервер инициализация всего
        //String input = "help";
        //Utils.runCommandFromString(input);
        try {

            while (true) {
                System.out.print("Write a command: ");
                String input = bufferedReader.readLine();
                Utils.runCommandFromString(input);
            }
        } catch (NullPointerException | NoSuchElementException e) {
            Utils.funExit();
        } catch (Exception e) {
            e.printStackTrace();
        }


        Worker bum = new Worker();
        WorkerDto workerDto = Transformer.WorkerToWorkerDto(bum);
        CommandRequestDto<WorkerDto> commandRequestDto = new CommandRequestDto<>("add", workerDto);
        AddCommandDto add = new AddCommandDto();

        Transformer transformer = new Transformer();
        bum.setName("maaan");
        bum.setId(1123);
        byte[] a = new byte[2048];

        WorkerDto man = Transformer.WorkerToWorkerDto(bum);

        add.setBum(man);
        ByteBuffer buf = ByteBuffer.wrap(a);
        buf.put(transformer.Serialize(man));

        CommandRequestDto<AddCommandDto> crd = new CommandRequestDto<>("add", add);//System.out.println(crd.getCommandArgs().getBum().getName() + " " + crd.getCommandName());

//        try {
//
//            serverCaller.sendToServer(transformer.Serialize(crd));}
//        catch (ServerNotFoundException e){
//            System.out.println(e.getMessage());
//        }


    }
}
