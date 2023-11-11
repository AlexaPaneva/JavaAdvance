package javaAdvanced.definingClasses.constructors;

public class Constructors {
    private String brand;
    private String model;
    private int horsePower;

    public Constructors(String brand) {
        this(brand, "unknown", -1);
    }

    public Constructors(String brand, String model) {
        this(brand, model, -1);
    }

    public Constructors(String brand, int horsePower) {
        this(brand, "unknown", horsePower);
    }

    public Constructors(String brand, String model, int horsePower) {
        setBrand(brand);
        setModel(model);
        setHorsePower(horsePower);
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public String carInfo() {
        return toString();
    }

    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP.", this.getBrand(), this.getModel(), this.getHorsePower());
    }

}
