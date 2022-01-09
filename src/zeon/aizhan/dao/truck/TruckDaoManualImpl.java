package zeon.aizhan.dao.truck;

import zeon.aizhan.model.Truck;

import java.util.List;

public class TruckDaoManualImpl implements TruckDao {
    private static TruckDaoManualImpl truckDaoManual;

    public TruckDaoManualImpl() {
    }

    @Override
    public void changeDriver() {

    }

    @Override
    public void startDriving() {

    }

    @Override
    public void startRepair() {

    }

    @Override
    public List<Truck> getAllTrucks() {
        return null;
    }

    public static TruckDaoManualImpl getInstance() {
        if (truckDaoManual == null) {
            truckDaoManual = new TruckDaoManualImpl();
        }
        return truckDaoManual;
    }

}
