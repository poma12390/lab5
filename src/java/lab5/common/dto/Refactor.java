package lab5.common.dto;

import lab5.common.Worker;

import java.io.*;

public class Refactor {
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    ObjectOutputStream out = null;
    ByteArrayInputStream bis;
    ObjectInput in = null;
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
    public byte[] Serialize(Object obj){
        try {
            out = new ObjectOutputStream(this.bos);
            out.writeObject(obj);
            out.flush();
            return bos.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bos.close();
            } catch (IOException ex) {
                // ignore close exception
            }
        }
    }
    public Object DeSerialize(byte[] arr){
        try {
            bis = new ByteArrayInputStream(arr);
            in = new ObjectInputStream(bis);
            return in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                // ignore close exception
            }
        }
    }
}
