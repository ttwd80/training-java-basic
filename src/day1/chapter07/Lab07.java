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
