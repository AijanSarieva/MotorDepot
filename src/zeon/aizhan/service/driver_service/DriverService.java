package zeon.aizhan.service.driver_service;

import zeon.aizhan.model.Driver;

import java.util.List;

public interface DriverService {
    Driver getFreeDriver(String id);
    List<Driver> getAllDrivers();
}
