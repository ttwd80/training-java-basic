package day1.chapter07;

public class Fish extends Animal {

    @Override
    public void sleep() {
        System.out.println("Fish.sleep()");
    }

    public void breathe() {
        System.out.println("Fish.breathe()");
    }

    public void swim() {
        System.out.println("Fish.swim()");
    }

}
