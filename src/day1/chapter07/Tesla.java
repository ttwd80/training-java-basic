package day1.chapter07;

public class Tesla extends Car {
    public Tesla(String owner) {
        super(owner);
    }

    @Override
    String fuelType() {
        return "electricity";
    }
}
