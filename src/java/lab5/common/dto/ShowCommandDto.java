package lab5.common.dto;

import lab5.common.Worker;

import java.util.List;

public class ShowCommandDto extends AbstractDto {
    private List<Worker> workers;

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }
}
