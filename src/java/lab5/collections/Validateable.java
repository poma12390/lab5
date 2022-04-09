package lab5.collections;

public interface Validateable {
    /**
     * validates all fields after json deserialization
     * @return
     */
    public boolean validate();
}