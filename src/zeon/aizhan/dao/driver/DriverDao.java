package zeon.aizhan.dao.driver;

import zeon.aizhan.model.Driver;

import java.util.List;

public interface DriverDao {
    Driver getFreeDriver();
    List<Driver> getAllDrivers();
}
