package day1.chapter07;

public class AnnaKendrick extends Artist implements Comedian {

    @Override
    public String getName() {
        return "Anna Kendrick";
    }

    @Override
    public void tellJoke() {
        System.out.println(getName() + " is telling a joke");
    }
}
