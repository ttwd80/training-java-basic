package day1.chapter07;

public abstract class Car {

    private String owner;

    abstract String fuelType();

    public Car(String owner) {
        this.owner = owner;
    }

    public void fuelUp() {
        System.out.println("Fueling up " + owner + " using " + fuelType());
    }
}
