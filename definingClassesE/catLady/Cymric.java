package javaAdvanced.definingClassesE.catLady;

public class Cymric extends Cat {
    private double furInMillimeters;

    public Cymric(String name, String type, double furInMillimeters) {
        super(name, type);
        this.furInMillimeters = furInMillimeters;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", super.toString(), this.furInMillimeters);
    }
}
