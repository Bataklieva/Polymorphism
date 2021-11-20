package vehicleExtension;

public class Bus extends VehicleAbstract {
    private static final double INCREASED_CONSUMPTION = 1.4;
    private boolean isEmpty;

    public Bus(double fuelQuantity, double liters, int capacity) {
        super(fuelQuantity, liters, capacity);
        isEmpty = false;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    @Override
    public void setConsumption(double consumption) {
        if (!isEmpty) {
            super.setConsumption(consumption + INCREASED_CONSUMPTION);
        }
    }

}
