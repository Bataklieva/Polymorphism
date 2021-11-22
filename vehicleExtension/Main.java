package vehicleExtension;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static String type;
    static double fuel;
    static double litres;
    static int capacity;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, VehicleSimulating> vehicles = new LinkedHashMap<>();

        readInput(sc); //for car
        vehicles.put("Car", new Car(fuel, litres, capacity));


        readInput(sc); //for truck
        vehicles.put("Truck", new Truck(fuel, litres, capacity));

        readInput(sc); //for bus
        vehicles.put("Bus", new Bus(fuel, litres, capacity));

        int n = Integer.parseInt(sc.nextLine());
        while (n-- > 0) {
            try {

                String[] readCommands = sc.nextLine().split("\\s+");
                String command = readCommands[0];
                String vehicleType = readCommands[1];
                double distanceOrLitres = Double.parseDouble(readCommands[2]);

                resultFromCommand(vehicles, command, vehicleType, distanceOrLitres);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

        vehicles.values().forEach(System.out::println);

    }

    private static void resultFromCommand(Map<String, VehicleSimulating> vehicle, String command, String vehicleType, double distanceOrLitres) {
        switch (command) {
            case "Drive":
                if (vehicle instanceof Bus) {
                    ((Bus) vehicle).setEmpty(false);
                }
                System.out.println(vehicle.get(vehicleType).drive(distanceOrLitres));

                break;

            case "DriveEmpty":
                if (vehicle instanceof Bus) {
                    ((Bus) vehicle).setEmpty(true);
                }
                System.out.println(vehicle.get("Bus").drive(distanceOrLitres));
                break;

            case "Refuel":
                vehicle.get(vehicleType).refueling(distanceOrLitres);
                break;
        }
    }

    private static void readInput(Scanner sc) {
        String[] input = sc.nextLine().split("\\s+");
        type = input[0];
        fuel = Double.parseDouble(input[1]);
        litres = Double.parseDouble(input[2]);
        capacity = Integer.parseInt(input[3]);
    }
}