package randomizer.entity;

public class Person {
    private final String name;
    private final int numberID;
    int status = 1;

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "ID:" + numberID + "." + name;
    }

    public Person(String name, int numberID) {
        this.name = name;
        this.numberID = numberID;
    }

    public int getNumberID() {
        return numberID;
    }
}
