package vehicle;

public class Car extends VehicleAbstract {
    private static final double FUEL_CONSUMPTION = 0.9;


    public Car(double fuelQuantity, double liters) {
        super(fuelQuantity, liters);
    }

    @Override
    public void setConsumption(double consumption) {
        super.setConsumption(consumption + FUEL_CONSUMPTION);
    }

}
