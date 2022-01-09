package zeon.aizhan.dao.truck_dao;

import zeon.aizhan.model.Truck;

import java.util.List;

public interface TruckDao {
    void changeDriver(List<Truck> id);
    void startDriving();
    void startRepair();
    List<Truck> getAllTrucks();

}
