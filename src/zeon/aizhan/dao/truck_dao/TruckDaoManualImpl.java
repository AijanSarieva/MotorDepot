package zeon.aizhan.dao.truck_dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import zeon.aizhan.model.Truck;

import java.io.FileNotFoundException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TruckDaoManualImpl implements TruckDao {
    private static TruckDaoManualImpl truckDaoManual;
    private Gson gson;
    private Reader reader;
    private Writer writer;

    public TruckDaoManualImpl() throws FileNotFoundException {
    }

    @Override
    public void changeDriver(List<Truck> trucks) {
        try {
            writer = Files.newBufferedWriter(Paths.get("src/TrucksDB.json"));
            new Gson().toJson(trucks,writer);
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void startDriving() {

    }

    @Override
    public void startRepair() {

    }

    @Override
    public List<Truck> getAllTrucks() {
        List<Truck> trucks = new ArrayList<>();
        try {
            reader = Files.newBufferedReader(Paths.get("src/TrucksDB.json"));
            trucks = new Gson().fromJson(reader, new TypeToken<List<Truck>>() {
            }.getType());
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trucks;
    }

    public static TruckDaoManualImpl getInstance() {
        if (truckDaoManual == null) {
            try {
                truckDaoManual = new TruckDaoManualImpl();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return truckDaoManual;
    }

}
