package lab5.collections;

public interface Collectionable extends Comparable<Collectionable>, Validateable{

    public int getId();
    /**
     * sets id, useful for replacing object in collection
     * @param ID
     */
    public void setId(int ID);

    public long getSalary();

    public String getName();

    /**
     * compairs two objects
     */
    public int compareTo(Collectionable worker);

    public boolean validate();
}