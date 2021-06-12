package day1.chapter07;

public class Bat extends Mammal {

    private boolean herbivore;

    public Bat(String name, boolean herbivore) {
        super(name);
        this.herbivore = herbivore;
    }

    public boolean isHerbivore() {
        return herbivore;
    }
}
