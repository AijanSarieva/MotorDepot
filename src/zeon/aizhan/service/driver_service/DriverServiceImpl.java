package zeon.aizhan.service.driver_service;

import zeon.aizhan.dao.driver_dao.DriverDao;
import zeon.aizhan.dao.driver_dao.DriverDaoManualImpl;
import zeon.aizhan.model.Driver;

import java.util.List;

public class DriverServiceImpl implements DriverService {
    private final DriverDao dao;
    private static DriverServiceImpl driverService;

    public DriverServiceImpl(DriverDao dao) {
        this.dao = dao;
    }

    @Override
    public Driver getFreeDriver( String  id) {
        return dao.getFreeDriver(id);
    }

    @Override
    public List<Driver> getAllDrivers() {
        return dao.getAllDrivers();
    }

    public static DriverServiceImpl getInstance(){
        if (driverService==null){
            driverService = new DriverServiceImpl(DriverDaoManualImpl.getInstance());
        }
        return driverService;
    }
}
