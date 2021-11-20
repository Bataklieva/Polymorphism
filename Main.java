package vehicle;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static String type;
    static double fuel;
    static double litres;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        readInput(sc); //for car
        VehicleSimulating car = new Car(fuel, litres);

        readInput(sc); //for truck
        VehicleSimulating truck = new Truck(fuel, litres);

        Map<String, VehicleSimulating> vehicles = new LinkedHashMap<>();
        vehicles.put("Car", car);
        vehicles.put("Truck", truck);

        int n = Integer.parseInt(sc.nextLine());
        while (n-- > 0) {

            String[] readCommands = sc.nextLine().split("\\s+");
            String command = readCommands[0];
            String vehicleType = readCommands[1];
            double distanceOrLitres = Double.parseDouble(readCommands[2]);

            commandValue(vehicles, command, vehicleType, distanceOrLitres);

        }

        System.out.println(car);
        System.out.println(truck);

    }

    private static void commandValue(Map<String, VehicleSimulating> vehicle, String command, String vehicleType, double distanceOrLitres) {
        switch (command) {
            case "Drive":
                System.out.println(vehicle.get(vehicleType).drive(distanceOrLitres));
                break;

            case "Refuel":
                vehicle.get(vehicleType).refueling(distanceOrLitres);
                break;
            default:
                throw new IllegalArgumentException("Not a proper command");
        }
    }

    private static void readInput(Scanner sc) {
        String[] input = sc.nextLine().split("\\s+");
        type = input[0];
        fuel = Integer.parseInt(input[1]);
        litres = Double.parseDouble(input[2]);
    }
}
