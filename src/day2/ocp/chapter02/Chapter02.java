package day2.ocp.chapter02;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Chapter02 {
    public static void main(String[] args) {
        Chapter02 chapter02 = new Chapter02();
        chapter02.demo();
    }

    private void demo() {
        System.out.println("Develop code that uses abstract classes and methods");
        demoAbstract();
        System.out.println();

        System.out.println("Develop code that uses the final keyword");
        demoFinal();
        System.out.println();

        System.out.println("Create inner classes including static inner class, local class, nested class, and anonymous inner class");
        demoInnerClass();
        System.out.println();

        System.out.println("Use enumerated types including methods, and constructors in an enum type");
        demoEnum();
        System.out.println();

        System.out.println("Develop code that declares, implements and/or extends interfaces and use the @Override annotation.");
        demoExtends();
        System.out.println();

        System.out.println("Create and use Lambda expressions");
        demoLambda();
    }

    private void useFunction(Function<String, Integer> f, String s) {
        System.out.println(f.apply(s));
    }

    private void demoLambda() {
        Function<String, Integer> f1 = s -> 10;
        System.out.println("Using function");
        useFunction(f1, "s");
        useFunction(f1, "xx");
        Function<String, Integer> f2 = s -> s.length();
        useFunction(f2, "s");
        useFunction(f2, "xx");

        Supplier<Integer> s1 = () -> new Random().nextInt(100);
        System.out.println("Using supplier");
        System.out.println(s1.get());
    }

    static interface Interface1 {

    }
    static interface Interface2 extends Interface1 {

            void doSomething();
    }
    //static interface Interface3 implements Interface1 {}
    static class Implementor implements Interface2 {

        @Override
        public void doSomething() {
            System.out.println("Doing something");
        }
    }
    private void demoExtends() {
        new Implementor();
    }

    static enum Planets {

        EARTH("Earth"),
        MARS("Mars"),
        SATURN("Saturn");

        private final String name;

        Planets(String name) {
            this.name = name;
        }

        String getName() {
            return name;
        }
    }

    void process(Planets p) {
        if (p == Planets.SATURN) {

        }
    }

    private void demoEnum() {
        process(Planets.EARTH);
        process(Planets.SATURN);
    }


    static interface Button {
        void click();
    }
    private void demoInnerClass() {
        class Inner {

        }
        Inner x = new Inner();

        Button b = new Button() {
            @Override
            public void click() {

            }
        };
        System.out.println("x is a type of " + x.getClass().getName());
        System.out.println("b is a type of " + b.getClass().getName());

    }

    private void demoInnerClass2() {
        //Inner x = new Inner();
    }

    static class F1 {
        void process1(){}
        final void process2(){}
    }

    static class F2 extends F1{

        @Override
        void process1(){

        }

        //final void process2(){}

    }

    static final class CF1 {

    }

    //Cannot inherit from final 'day2.ocp.chapter02.Chapter02.CF1'
    //static class CF2 extends  CF1 {}


    private void demoFinal() {
        //final pakai di 3 tempat
        //at variable

        final int m = 32;
        //m = 5; //error

        //used with inheritance, stop override
    }

    //abstract class with zero abstract methods
    static abstract class Car {

    }

    //abstract class with one abstract method
    static abstract class Animal {
        abstract void eat();

        void sleep() {
            System.out.println("Animal.sleep()");
        }
    }

    static class Fish extends Animal {

        @Override
        void eat() {
            System.out.println("Fish.eat()");
        }
    }

    static abstract class Mammal extends Animal {
        //abstract void eat();
    }

    private void demoAbstract() {
        Fish fish = new Fish();
        fish.sleep();
        fish.eat();
    }
}
