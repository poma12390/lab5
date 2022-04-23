package lab5.server;


import lab5.client.commands.AddCommand;
import lab5.common.Transformer;
import lab5.common.dto.AddCommandDto;
import lab5.common.dto.CommandRequestDto;

import java.io.Serializable;

public class ClientReceiver {

    void run() {
        // TODO: запустить цикл получения датаграммов с клиента
    }

    public void requestFromClient(byte[] requestContent){

        // TODO: десериализация requestContent -> commandDto
        // вместо этого пока создадим "в лоб"
        Transformer transformer = new Transformer();
        CommandRequestDto<? extends Serializable> requestObject = (CommandRequestDto<? extends Serializable>) transformer.DeSerialize(requestContent);
        AddCommandDto add = (AddCommandDto) requestObject.getCommandArgs();
        System.out.println(add.getBum().getName() + " server");
        //CommandRequestDto

    }


}
