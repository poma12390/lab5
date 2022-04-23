package lab5.common.dto;

import java.io.Serializable;

public class UpdateIdCommandDto extends AbstractDto{
    private WorkerDto bum;

    public WorkerDto getBum() {
        return bum;
    }

    public void setBum(WorkerDto bum) {
        this.bum = bum;
    }
}
