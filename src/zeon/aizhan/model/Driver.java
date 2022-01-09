package zeon.aizhan.model;

public class Driver {
    private String id;
    private String name;
    private boolean inTruck;

    public Driver(String id, String name, boolean inTruck) {
        this.id = id;
        this.name = name;
        this.inTruck = inTruck;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getInTruck() {
        return inTruck;
    }

    public void setInTruck(boolean inTruck) {
        this.inTruck = inTruck;
    }
}
