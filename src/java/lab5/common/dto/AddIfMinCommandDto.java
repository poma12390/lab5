package lab5.common.dto;

public class AddIfMinCommandDto extends AbstractDto{
    private WorkerDto bum;

    public WorkerDto getBum() {
        return bum;
    }

    public void setBum(WorkerDto bum) {
        this.bum = bum;
    }
}
