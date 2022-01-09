package zeon.aizhan.dao.driver;

import zeon.aizhan.model.Driver;

import java.util.List;

public class DriverDaoManualImpl implements DriverDao{
    private static DriverDaoManualImpl driverDaoManual;
    @Override
    public Driver getFreeDriver() {
        return null;
    }

    @Override
    public List<Driver> getAllDrivers() {
        return null;
    }

    public static DriverDaoManualImpl getInstance(){
        if (driverDaoManual==null){
            driverDaoManual = new DriverDaoManualImpl();
        }
        return driverDaoManual;
    }
}
