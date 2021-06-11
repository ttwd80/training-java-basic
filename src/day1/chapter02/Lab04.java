package day1.chapter02;

import java.util.ArrayList;
import java.util.List;

public class Lab04 {
    public static void main(String[] args) {
        Lab04 lab = new Lab04();
        lab.demo();
    }

    void demo() {
        System.out.println("Java object assignment");
        javaObjectAssignment();
        System.out.println();
        System.out.println("Autoboxing and unboxing");
        autoBoxingAndUnboxing();

    }

    private void autoBoxingAndUnboxing() {
        Integer a = new Integer(10);
        int b = 20;
        Integer c = b; //assign Integer from int
        int d = a; //assign int from Integer
        Integer x = null;
        // int y = x; // this will cause a NullPointerException
        System.out.println("a = " + a + ", b = " + b + ", c = " + c + ", d = " + d);
    }

    private void javaObjectAssignment() {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = list1;
        System.out.println("list1.size() = " + list1.size() + ", list2.size() = " + list2.size());
        list1.add(Integer.valueOf(0));
        System.out.println("list1.size() = " + list1.size() + ", list2.size() = " + list2.size());
    }
}
