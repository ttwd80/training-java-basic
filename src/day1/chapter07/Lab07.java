package day1.chapter07;

public class Lab07 {
    public static void main(String[] args) {
        Lab07 lab = new Lab07();
        lab.demo();
    }

    private void demo() {
        System.out.println("Develop code that makes use of polymorphism");
        System.out.println("Not polymorphism");
        notPolymorphism();
        System.out.println("Polymorphism");
        polymorphism();
        System.out.println();

        System.out.println("Develop code that overrides methods");
        override();

    }

    private void override() {
        Fish fish = new Fish();

        System.out.println("use base class method, no override");
        //eat is defined in Animal
        fish.eat();

        System.out.println("use method defined only in subclass, no override");
        //swim is defined in Fish and not Animal
        fish.swim();

        System.out.println("use method defined in both parent class and subclass, with annotation");
        //sleep is defined in both Animal and Fish and has @Override
        fish.sleep();

        System.out.println("use method defined in both parent class and subclass, without annotation");
        //breathe is defined in both Animal and Fish and does not have @Override
        //still considered override, @Override should be added, not not mandatory
        fish.breathe();

        //not adding @Override to an override method is allowed
        //adding @Override to a non-override method will result in a compilation error

    }

    private void notPolymorphism() {
        Animal animal = new Animal();
        Fish fish = new Fish();

        animal.eat();
        animal.sleep();
        animal.breathe();

        fish.eat();
        fish.sleep();
        fish.breathe();
    }

    private void polymorphism() {
        Animal animal1 = new Animal();
        Animal animal2 = new Fish();
        animal1.eat();
        animal1.sleep();
        animal1.breathe();

        animal2.eat();
        animal2.sleep();
        animal2.breathe();
    }
}
