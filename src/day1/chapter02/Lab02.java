package day1.chapter02;

import java.util.ArrayList;
import java.util.List;

public class Lab02 {

    int value;

    public static void main(String[] args) {
        Lab02 lab = new Lab02();
        lab.demo();
    }

    void demo() {
        System.out.println("Declare and assign");
        declareAndAssign();
        System.out.println();
        System.out.println("Read/write to object field");
        readWriteToObjectField();
        System.out.println();
        System.out.println("Java object assignment");
        javaObjectAssignment();
        System.out.println();
        System.out.println("Autoboxing and unboxing");
        autoBoxingAndUnboxing();

    }

    void readWriteToObjectField() {
        Lab02 lab = new Lab02();

        System.out.println("Reading from object field");
        System.out.println("lab.value = " + lab.value);

        System.out.println("Writing to object field");
        lab.value = 300;

        System.out.println("Reading from object field");
        System.out.println("lab.value = " + lab.value);
    }

    void declareAndAssign() {
        //Declare then assign
        int a;
        a = 10;
        System.out.println("a = " + a);

        //Declare and assign
        int b = 20;
        System.out.println("b = " + b);

        //Declare and not assign - compile time error
        int c;
        //Variable 'c' might not have been initialized
        //System.out.println("c = " + c);
    }

    void autoBoxingAndUnboxing() {
        Integer a = new Integer(10);
        int b = 20;
        Integer c = b; //assign Integer from int
        int d = a; //assign int from Integer
        Integer x = null;
        // int y = x; // this will cause a NullPointerException
        System.out.println("a = " + a + ", b = " + b + ", c = " + c + ", d = " + d);
    }

    void javaObjectAssignment() {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = list1;
        System.out.println("list1.size() = " + list1.size() + ", list2.size() = " + list2.size());
        list1.add(Integer.valueOf(0));
        System.out.println("list1.size() = " + list1.size() + ", list2.size() = " + list2.size());
    }
}
