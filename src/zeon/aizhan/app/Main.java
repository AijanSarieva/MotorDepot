package zeon.aizhan.app;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import zeon.aizhan.model.Driver;
import zeon.aizhan.model.Truck;
import zeon.aizhan.service.driver_service.DriverService;
import zeon.aizhan.service.driver_service.DriverServiceImpl;
import zeon.aizhan.service.truck_service.TruckService;
import zeon.aizhan.service.truck_service.TruckServiceImpl;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Gson pretty = new GsonBuilder().setPrettyPrinting().create();
    private static final TruckService truckService = TruckServiceImpl.getInstance();
    private static final DriverService driverService = DriverServiceImpl.getInstance();
    private static List<Truck> trucks;
    private static List<Driver> drivers;

    public static void main(String[] args) {
        runOn();
    }

    private static void runOn() {
        trucks = truckService.getAllTrucks();
        drivers = driverService.getAllDrivers();
        printTrucks(trucks);
        System.out.println("Choose one of the Trucks: ");
        int index = scanner.nextInt()-1;
        showUserInputTruck(index);
        int command = scanner.nextInt();
        performUserCommand(command,index);
        drivers = driverService.getAllDrivers();
        printDrivers(drivers);
        runOn();
    }

    private static void printDrivers(List<Driver> drivers) {
        System.out.println("----------------drivers----------------");
        System.out.format("%12s%12s%12s", " #", "name", " In Truck");
        System.out.println();
        for (int i = 0; i < drivers.size(); i++) {
            Driver driver = drivers.get(i);
            System.out.format("%12s%12s%12s", driver.getId(), driver.getName(), driver.getInTruck());
            System.out.println();
        }
    }

    private static void showUserInputTruck(int id) {
        try {
            printTruckInfo(trucks.get(id));
        } catch (Exception e) {
            showUserInputTruck(nextInput("There is no truck with this id!\n" +
                    "Please,type new one: "));
        }
    }

    private static void performUserCommand(int command,int index) {
        switch (command + "") {
            case "1" -> changeDriver(index);
            case "2" -> truckService.startDriving();
            case "3" -> truckService.startRepair();
            default -> performUserCommand(nextInput("Inappropriate command!\n" +
                    " Type new one: "),index);
        }
    }

    private static void changeDriver(int index) {
        Driver driver ;
        if (!Objects.equals(trucks.get(index).getDriver(), "")){
            driver = driverService.getFreeDriver(trucks.get(index).getDriver());
        }else{
            driver = driverService.getFreeDriver(null);
        }
        if (driver==null){
            performUserCommand(nextInput("There is no free Drivers:(\n" +
                    "Choose another command: "),index);
        }
        truckService.changeDriver(trucks,trucks.get(index).getId()+"",driver);
        System.out.println("--------------------------------------");
        System.out.println(" Driver successfully changed!");
        System.out.println("--------------------------------------");
    }

    private static int nextInput(String message) {
        System.out.print(message);
        return scanner.nextInt();
    }

    private static void printTrucks(List<Truck> trucks) {
        System.out.println("----------------Trucks----------------");
        System.out.format("%12s%12s%12s%12s", " #", "Bus", " Driver", " State");
        System.out.println();
        for (int i = 0; i < trucks.size(); i++) {
            Truck truck = trucks.get(i);
            System.out.format("%12s%12s%12s%12s", truck.getId(), drivers.get(i).getName(), truck.getDriver(), truck.getState());
            System.out.println();
        }
    }

    private static void printTruckInfo(Truck truck) {
        System.out.println("---------- Tuck-info-----------");
        System.out.println(truck);
        System.out.println("Press 1 to change Driver");
        System.out.println("Press 2 to send to the Route");
        System.out.println("Press 3 to send to the Repairing");
    }

}
