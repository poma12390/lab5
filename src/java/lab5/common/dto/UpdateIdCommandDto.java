package lab5.common.dto;

public class UpdateIdCommandDto extends AbstractDto{
    private int workerId;

    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }
}
