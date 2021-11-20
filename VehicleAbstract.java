package vehicle;

import java.text.DecimalFormat;

public abstract class VehicleAbstract implements VehicleSimulating {
    private double fuelQuantity;
    private double consumption;

    public VehicleAbstract(double fuelQuantity, double liters) {
        this.fuelQuantity = fuelQuantity;
        this.setConsumption(liters);
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    @Override
    public String drive(double distance) {
        double neededFuel = getConsumption() * distance;

        if (neededFuel > getFuelQuantity()) {
            return String.format("%s needs refueling", getClass().getSimpleName());
        }

        this.setFuelQuantity(getFuelQuantity() - neededFuel);
        DecimalFormat formatter = new DecimalFormat("##.##");

        return String.format("%s travelled %s km", getClass().getSimpleName(), formatter.format(distance));
    }

    @Override
    public void refueling(double litres) {
        this.fuelQuantity += litres;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
