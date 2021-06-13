package day3.ocp.chapter04;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.*;
import java.util.stream.Collectors;

public class Chapter04 {
    public static void main(String[] args) {
        Chapter04 chapter04 = new Chapter04();
        chapter04.demo();
    }

    private void demo() {
        System.out.println("Use  the built-in interfaces included in the java.util.function package such as Predicate, Consumer, Function, and Supplier");
        demoFunctions();
        System.out.println();

        System.out.println("Develop code that uses primitive versions of functional interfaces");
        demoPrimitives();
        System.out.println();

        System.out.println("Develop code that uses binary versions of functional interfaces");
        demoBi();
        System.out.println();

        System.out.println("Develop code that uses the UnaryOperator interface");
        demoUnary();
        System.out.println();
    }

    private void demoUnary() {
        List<Integer> nums = Arrays.asList(1, 20, 8, 9, 42, 7, 6);
        Function<Integer, Integer> f1 = n -> n + 1_000;
        System.out.println(convert(nums, f1));
        System.out.println(convert(nums, n -> n));
        System.out.println(convert(nums, Function.identity()));
    }

    private  List<Integer> convert(List<Integer> items, Function<Integer, Integer> f) {
        return items.stream().map(f).collect(Collectors.toList());
    }

    private void demoBi() {
        //also comes in Bi format
        // <Integer, String>
        //returns true if the length of the string is > the integer
        BiPredicate<Integer, String> bd1 = (n1, s1) -> s1.length() > n1;
        System.out.println("BiPredicate:");
        System.out.println(bd1.test(4, "aaa"));
        System.out.println(bd1.test(1, "aaa"));

        BiConsumer<String, Integer> bd2 = (String s1, Integer n1) -> {
            System.out.println("s1 = " + s1 + ", n1 = " + n1);
        };
        bd2.accept("number of planets", 8);
        bd2.accept("number of states", 14);

        BiFunction<String, String, Integer> bd3 = (s1, s2) -> s1.length() + s2.length();
        System.out.println("BiFunction:");
        System.out.println(bd3.apply("aa", "a"));
        ;
    }

    private void demoPrimitives() {
        //some come in primitive form as well
        IntPredicate np = n -> n > 20;
        System.out.println("IntPredicate");
        System.out.println(np.test(4));
        System.out.println(np.test(400));

        DoublePredicate dp = d -> d == 3.14;
        System.out.println("DoublePredicate");
        System.out.println(dp.test(3.11));
        System.out.println(dp.test(3.14));

        LongSupplier ns = () -> new Random().nextLong();
        System.out.println("LongSupplier");
        System.out.println(ns.getAsLong());
        System.out.println(ns.getAsLong());
    }

    private void demoFunctions() {
        //Accepts an object and returns a boolean
        Predicate<Integer> d1 = n -> n > 10;
        System.out.println("Predicate:");
        System.out.println(d1.test(10));
        System.out.println(d1.test(20));

        //Accepts a String and processes it, void return type
        Consumer<String> d2 = s -> {
            System.out.println("consumer -> " + s);
        };
        System.out.println("Consumer:");
        d2.accept("a");
        d2.accept("b");

        //Accepts Boolean and returns A String
        Function<Boolean, String> d3 = (b) -> b ? "betul" : "salah";
        System.out.println("Function:");
        System.out.println(d3.apply(true));
        System.out.println(d3.apply(false));


        //returns something
        Supplier<Integer> d4 = () -> new Random().nextInt(10);
        System.out.println("Supplier:");
        System.out.println(d4.get());
        System.out.println(d4.get());
    }
}
