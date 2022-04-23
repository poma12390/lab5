package lab5.common;

import lab5.common.dto.CommandRequestDto;
import lab5.common.dto.WorkerDto;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Transformer {

    public static WorkerDto WorkerToWorkerDto(Worker bum){
        WorkerDto man = new WorkerDto();
        man.setName(bum.getName());
        man.setCoordinates(bum.getCoordinates());
        man.setCreationDate(bum.getCreationDate());
        man.setSalary(bum.getSalary());
        man.setId(bum.getId());
        man.setStartDate(bum.getStartDate());
        man.setEndDate(bum.getEndDate());
        man.setPerson(bum.getPerson());
        man.setPosition(bum.getPosition());
        return man;
    }

    public byte[] Serialize(Serializable obj){
        try(ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            ObjectOutputStream out = new ObjectOutputStream(bos);
            out.writeObject(obj);
            out.flush();
            return bos.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Object DeSerialize(byte[] arr){
        ByteArrayInputStream bis = new ByteArrayInputStream(arr);
        try(ObjectInput in = new ObjectInputStream(bis)) {
            return in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public CommandRequestDto<? extends Serializable> Testdes(byte[] arr){
        ByteArrayInputStream bis = new ByteArrayInputStream(arr);
        try(ObjectInput in = new ObjectInputStream(bis)) {
            return (CommandRequestDto<? extends Serializable>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
