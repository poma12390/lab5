package lab5.common.dto;

public class FilterBySalaryCommandDto extends AbstractDto{
    private float salary;

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}
