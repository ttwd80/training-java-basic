package day2.ocp.chapter01;

import java.lang.reflect.Array;
import java.util.*;

public class Chapter01 {
    public static void main(String[] args) {
        Chapter01 chapter01 = new Chapter01();
        chapter01.demo();
    }

    private void demo() {
        System.out.println("Implement encapsulation");
        System.out.println("Implement inheritance including visibility modifiers and composition.");
        System.out.println("Implement polymorphism.");

        System.out.println("Override hashCode, equals, and toString methods from Object class");
        sampleHashCodeEqualsToString();
        System.out.println();

        System.out.println("Create and use singleton classes and immutable classes");
        singletonImmutable();
        System.out.println();

        System.out.println("Develop code that uses static keyword on initialize blocks, variables, methods, and classes");
        staticInit();
    }

    static class Static1 {
        private String name;
        static int count;

        static {
            //init
            count = 10;
        }

    }

    private void staticInit() {

    }

    //immutable
    static class Im1 {
        final private String name;
        final private int year;

        public Im1(String name, int year) {
            this.name = name;
            this.year = year;
        }

        public String getName() {
            return name;
        }

        public int getYear() {
            return year;
        }
    }

    //not immutable
    static class Im2 {
        final private List<Integer> values;

        public Im2(List<Integer> values) {
            this.values = values;
        }

        public List<Integer> getValues() {
            return values;
        }
    }

    //make it immutable
    static class Im3 {
        final private List<Integer> values;

        public Im3(List<Integer> values) {
            this.values = values;
        }

        public List<Integer> getValues() {
            return new ArrayList<>(values);
        }
    }

    private void singletonImmutable() {
        String s1 = "something";
        //s1 is immutable
        char[] c = s1.toCharArray();
        System.out.println("s1 to char array");
        c[0] = 'd';
        System.out.println(c);
        System.out.println("s1 = " + s1);

        List<Integer> a = new ArrayList<>(Arrays.asList(1,100,50));
        Im2 im2 = new Im2(a);
        System.out.println(im2.getValues());
        im2.getValues().add(30);
        System.out.println(im2.getValues());

        List<Integer> b = new ArrayList<>(Arrays.asList(1,100,50));
        Im3 im3 = new Im3(b);
        System.out.println(im3.getValues());
        im3.getValues().add(30);
        b.add(50);
        System.out.println(im3.getValues());

    }

    static class A {
        private String name;

        public A(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "A{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    static class B {
        private String name;

        public B(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            B b = (B) o;
            return name.equals(b.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public String toString() {
            return "B{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    private void sampleHashCodeEqualsToString() {
        String a = "";

        //baseclass can point to subclass
        //Object is the baseclass
        Object b = a;

        Set<A> set1 = new HashSet<>();
        set1.add(new A("item 1"));
        set1.add(new A("item 2"));
        set1.add(new A("item 3"));
        System.out.println(set1.size());
        System.out.println(set1);

        Set<B> set2 = new HashSet<>();
        set2.add(new B("item 1"));
        set2.add(new B("item 2"));
        set2.add(new B("item 3"));
        System.out.println(set2.size());
        System.out.println(set2);

        List<A> la = new ArrayList<>();
        la.add(new A("item 1"));
        A value = new A("item 1");
        System.out.println("ada ke ta? " + la.contains(value));


        List<B> lb = new ArrayList<>();
        lb.add(new B("item 1"));
        B valueB = new B("item 1");
        System.out.println("ada ke ta? " + lb.contains(valueB));

    }
}
