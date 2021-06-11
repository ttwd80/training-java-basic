package day1.chapter06;

public class Lab06 {
    static int counter = 0;

    public static void main(String[] args) {
        Lab06 lab = new Lab06();
        lab.demo();
    }

    private void demo() {
        System.out.println("Create methods with arguments and return values; including overloaded methods");
        simpleMethodsIncludingOverloaded();
        System.out.println();

        System.out.println("Apply the static keyword to methods and fields");
        applyStatic();
        System.out.println();

        System.out.println("Create and overload constructors; differentiate between default and user defined constructors");
        constructors();
        System.out.println();

    }

    private void constructors() {
        System.out.println("Person has not defined any constructors");
        Person person = new Person();
        System.out.println(person);

        System.out.println("Planet has one constructor");
        // ERROR, one constructor and it requires 2 parameters
        // Planet planet = new Planet();
        Planet planet = new Planet("Earth", 150_000_000);
        System.out.println(person);

        System.out.println("Planet has multiple constructors");
        Country c1 = new Country();
        Country c2 = new Country("Canada");
        System.out.println("c1.getName() => " + c1.getName());
        System.out.println("c2.getName() => " + c2.getName());
    }

    private void applyStatic() {
        counter = 10;
        //non-static to static
        System.out.println("static counter = " + counter);

        static1();
        static2();
    }

    static void static1() {
        System.out.println("in static method static1");
    }

    static void static2() {
        System.out.println("in static method static2");
        // nonStatic1(); //error
    }

    void nonStatic1() {
        System.out.println("in non-method nonStatic1");
    }

    private void simpleMethodsIncludingOverloaded() {
        int a = 10;
        int b = 5;
        System.out.println("multiple(a, b) => " + multiple(a, b));
        String c = "#";
        int d = 3;
        System.out.println("multiple(c, d) => " + multiple(c, d));
        String e = "@";
        System.out.println("multiple(e) => " + multiple(e));

    }

    private int multiple(int a, int b) {
        return a * b;
    }

    private String multiple(String a) {
        return multiple(a, 1);
    }

    private String multiple(String a, int b) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < b; i++) {
            sb.append(a);
        }
        return sb.toString();
    }
}
