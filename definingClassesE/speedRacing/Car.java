package javaAdvanced.definingClassesE.speedRacing;

public class Car {

    private String model;
    private double fuelAmount;
    private double fuelCostPerKilometer;

    private int traveledDistance;

    public Car(String model, double fuelAmount, double fuelCostPerKilometer) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPerKilometer = fuelCostPerKilometer;
        this.traveledDistance = 0;
    }

    public boolean hasSufficientFuel(int kilometers) {
        return this.fuelAmount >= calculateNeededFuel(kilometers);
    }

    public void decreaseFuel(int kilometers) {
        this.fuelAmount -= calculateNeededFuel(kilometers);
    }

    public void increaseTravelDistance(int kilometers) {
        this.traveledDistance += kilometers;
    }


    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.traveledDistance);
    }

    private double calculateNeededFuel(int kilometers) {
        return this.fuelCostPerKilometer * kilometers;
    }
}
