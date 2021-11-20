package vehicle;

public class Truck extends VehicleAbstract {
    private static final double FUEL_CONSUMPTION = 1.6;
    private static final double REFUELING_PROBLEM = 0.95;

    public Truck(double fuelQuantity, double liters) {
        super(fuelQuantity, liters);
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
