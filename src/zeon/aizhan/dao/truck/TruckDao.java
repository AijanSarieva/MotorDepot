package zeon.aizhan.dao.truck;

import zeon.aizhan.model.Truck;

import java.util.List;

public interface TruckDao {
    void changeDriver();
    void startDriving();
    void startRepair();
    List<Truck> getAllTrucks();

}
