package vehicleExtension;

public class Truck extends VehicleAbstract {
    private static final double FUEL_CONSUMPTION = 1.6;
    private static final double REFUELING_PROBLEM = 0.95;

    public Truck(double fuelQuantity, double liters, int capacity) {
        super(fuelQuantity, liters, capacity);
    }

    @Override
    public void setConsumption(double consumption) {
        super.setConsumption(consumption + FUEL_CONSUMPTION);
    }

    @Override
    public void refueling(double litres) {
        this.setFuelQuantity(getFuelQuantity() + (litres * REFUELING_PROBLEM));
    }
}
