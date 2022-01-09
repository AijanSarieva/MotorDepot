package zeon.aizhan.dao.driver_dao;

import zeon.aizhan.model.Driver;

import java.util.List;

public interface DriverDao {
    Driver getFreeDriver(String id);
    List<Driver> getAllDrivers();
}
