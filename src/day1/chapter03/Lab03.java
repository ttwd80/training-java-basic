package day1.chapter03;

import java.util.Arrays;
import java.util.List;

public class Lab03 {
    public static void main(String[] args) {
        Lab03 lab = new Lab03();
        lab.demo();
    }

    void demo() {
        System.out.println("All operators");
        allOperators();
        System.out.println();

        System.out.println("Parenthesis");
        parenthesis();
        System.out.println();

        System.out.println("Equality");
        equality();
        System.out.println();

        System.out.println("Using switch");
        usingSwitch();
    }

    private void usingSwitch() {
        processSwitch("A");
        processSwitch("B");
        processSwitch("Z");
    }

    private void processSwitch(String value) {
        System.out.println("If the input was " + value);
        switch (value) {
            case "A":
                System.out.println("First item.");
                break;
            case "B":
                System.out.println("Secomd item.");
                System.out.println("Still secomd item.");
            case "C":
                System.out.println("Item #3");
            case "D":
                System.out.println("Item #4");
                break;
            default:
                System.out.println("No match");
        }
    }

    private void equality() {
        List<Integer> a = Arrays.asList(100);
        List<Integer> b = Arrays.asList(100);
        List<Integer> c = Arrays.asList(200);
        List<Integer> d = a;

        //different object vs same object
        System.out.println("a == b = " + (a == b)  + ", a == d = " + (a == d));

        //different value
        System.out.println("a == c = " + (a == c)  + ", a.equals(c) = " + (a.equals(c)));

        //same value, different object
        System.out.println("a == b = " + (a == b)  + ", a.equals(b) = " + (a.equals(b)));

    }

    private void parenthesis() {
        int a = 100;
        int b = 200;
        int c = 2;
        System.out.println("a + b * c = " + (a + b * c));
        System.out.println("(a + b) * c = " + ((a + b) * c));
    }

    private void allOperators() {
        int a = 100;
        int b = 100;
        System.out.println("a++ = " + (a++) + ", --b = " + (--b));
        System.out.println("a = " + a + ", b = " + b);
        int c = 100;
        int d = -10;
        boolean e = true;
        System.out.println("-c = " + (-c) + ", -d = " + (-d) + ", !e = " + (!e));
        int f = 10;
        int g = 108;
        System.out.println("f * g = " + (f * g) + ", g / f = " + (g / f) + ", g % f = " + (g % f));
        int i = 12;
        int j = 14;
        System.out.println("i + j = " + (i * j) + ", i - j = " + (i - j));
        int k = 1024;
        int m = 2;
        System.out.println("k >> m = " + (k >> m) + ", k << m = " + (k << m));
        int n = -16;
        int p = 1;
        System.out.println("n >> p = " + (n >> p) + ", n >>> p = " + (n >>> p));
        int q = 10;
        int r = 11;
        int s = 10;
        System.out.println("q > r = " + (q > r) + ", q < r = " + (q < r));
        System.out.println("q == r = " + (q == r) + ", q == s = " + (q == s) + ", q != r = " + (q != r) + ", q != s = " + (q != s));
        int t = 15;
        int u = 5;
        int v = 16;
        System.out.println("t & u = " + (t & u) + ", t & v = " + (t & v));
        System.out.println("t ^ u = " + (t ^ u) + ", t ^ v = " + (t ^ v));
        System.out.println("t | u = " + (t | u) + ", t | v = " + (t | v));
        boolean w = true;
        boolean x = false;
        System.out.println("w && x = " + (w && x) + ", w || x = " + (w || x));
        String value = null;
        System.out.println("Ternary operator");
        value = ("zero".length() > 10 ? "long" : "short");
        System.out.println("value = " + value);
    }
}
