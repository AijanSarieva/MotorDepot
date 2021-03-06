package zeon.aizhan.model;

public class Truck {
    private String id;
    private String name;
    private String driverId;
    private String state;

    public Truck(String id, String name, String driverId, String state) {
        this.id = id;
        this.name = name;
        this.driverId = driverId;
        this.state = state;
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

    public String getDriver() {
        return driverId;
    }

    public void setDriver(String driver) {
        this.driverId = driver;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", driverId='" + driverId + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
