package lab5.common.dto;

public class RemoveByIdCommandDto extends AbstractDto{
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
