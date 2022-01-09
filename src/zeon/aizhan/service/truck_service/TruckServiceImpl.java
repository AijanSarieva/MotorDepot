package zeon.aizhan.service.truck_service;

import zeon.aizhan.dao.truck_dao.TruckDao;
import zeon.aizhan.dao.truck_dao.TruckDaoManualImpl;
import zeon.aizhan.model.Driver;
import zeon.aizhan.model.Truck;
import zeon.aizhan.service.driver_service.DriverService;
import zeon.aizhan.service.driver_service.DriverServiceImpl;

import java.util.List;
import java.util.Objects;

public class TruckServiceImpl implements TruckService{
    private static  TruckServiceImpl truckService;
    private final TruckDao dao;
    private static final DriverService driverService = DriverServiceImpl.getInstance();

    public TruckServiceImpl(TruckDao dao) {
        this.dao = dao;
    }


    @Override
    public void changeDriver(List<Truck> trucks,String id,Driver freeDriver) {
        trucks.forEach((k)->{
            if (Objects.equals(k.getId(), id)){
                if (k.getDriver()!=null){
                    k.setDriver(freeDriver.getId());
                }
            }
        });
        dao.changeDriver(trucks);
    }

    @Override
    public void startDriving() {

    }

    @Override
    public void startRepair() {

    }

    @Override
    public List<Truck> getAllTrucks() {
        return dao.getAllTrucks();
    }
    public static TruckServiceImpl getInstance(){
        if (truckService == null){
            truckService = new TruckServiceImpl(TruckDaoManualImpl.getInstance());
        }
        return truckService;
    }
}
