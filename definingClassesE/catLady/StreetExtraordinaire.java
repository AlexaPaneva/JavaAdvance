package javaAdvanced.definingClassesE.catLady;

public class StreetExtraordinaire extends Cat {
    private double meowing;

    public StreetExtraordinaire(String name, String type, double meowing) {
        super(name, type);
        this.meowing = meowing;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", super.toString(), this.meowing);
    }
}
