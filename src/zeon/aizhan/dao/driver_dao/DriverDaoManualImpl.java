package zeon.aizhan.dao.driver_dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import zeon.aizhan.model.Driver;
import zeon.aizhan.model.Truck;

import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class DriverDaoManualImpl implements DriverDao {
    private static DriverDaoManualImpl driverDaoManual;
    private Reader reader;
    private Writer writer;

    @Override
    public Driver getFreeDriver(String id) {
        List<Driver> drivers;
        Driver result = null;
        try {
            reader = Files.newBufferedReader(Paths.get("src/DriversDB.json"));
            drivers = new Gson().fromJson(reader, new TypeToken<List<Driver>>() {
            }.getType());
            for (int i = 0; i < drivers.size(); i++) {
                if (Objects.equals(drivers.get(i).getId(), id)) {
                    drivers.get(i).setInTruck(false);
                } else if (!drivers.get(i).getInTruck()) {
                    drivers.get(i).setInTruck(true);
                    result = drivers.get(i);
                    break;
                }
            }
            writer = Files.newBufferedWriter(Paths.get("src/DriversDB.json"));

            new Gson().toJson(drivers, writer);
            reader.close();
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Driver> getAllDrivers() {
        List<Driver> drivers = new ArrayList<>();
        try {
            reader = Files.newBufferedReader(Paths.get("src/DriversDB.json"));
            drivers = new Gson().fromJson(reader, new TypeToken<List<Driver>>() {
            }.getType());
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return drivers;
    }

    public static DriverDaoManualImpl getInstance() {
        if (driverDaoManual == null) {
            driverDaoManual = new DriverDaoManualImpl();
        }
        return driverDaoManual;
    }
}
