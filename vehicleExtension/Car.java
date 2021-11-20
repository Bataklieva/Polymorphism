package vehicleExtension;

public class Car extends VehicleAbstract {
    private static final double FUEL_CONSUMPTION = 0.9;


    public Car(double fuelQuantity, double liters, int capacity) {
        super(fuelQuantity, liters, capacity);
    }

    @Override
    public void setConsumption(double consumption) {
        super.setConsumption(consumption + FUEL_CONSUMPTION);
    }

}
