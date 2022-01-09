package zeon.aizhan.service.truck_service;

import zeon.aizhan.model.Driver;
import zeon.aizhan.model.Truck;

import java.util.List;

public interface TruckService {

    void changeDriver(List<Truck> trucks, String id, Driver driver);
    void startDriving();
    void startRepair();
    List<Truck> getAllTrucks();
}
