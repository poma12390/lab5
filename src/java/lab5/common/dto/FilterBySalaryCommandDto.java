package lab5.common.dto;

import lab5.common.Worker;

import java.util.List;
import java.util.Set;

public class FilterBySalaryCommandDto extends AbstractDto{
    private float salary;

    public float getSalary() {
        return salary;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }

    private List<Worker> workers;

    public void setSalary(float salary) {
        this.salary = salary;
    }
}




