package day1.chapter06.ocean;

public class Fish {
    private String name;
    private boolean poisonous;
    private boolean saltwater;

    public Fish(String name, boolean poisonous, boolean saltwater) {
        this.name = name;
        this.poisonous = poisonous;
        this.saltwater = saltwater;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPoisonous(boolean poisonous) {
        this.poisonous = poisonous;
    }

    public boolean isPoisonous() {
        return poisonous;
    }

    public void setSaltwater(boolean saltwater) {
        this.saltwater = saltwater;
    }

    public boolean isSaltwater() {
        return saltwater;
    }

    @Override
    public String toString() {
        return "Fish{" +
                "name='" + name + '\'' +
                ", poisonous=" + poisonous +
                ", saltwater=" + saltwater +
                '}';
    }
}
