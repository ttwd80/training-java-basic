package day1.chapter05;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Lab05 {
    public static void main(String[] args) {
        Lab05 lab = new Lab05();
        lab.demo();
    }

    private void demo() {
        System.out.println("Create and use while loops");
        whileLoops();
        System.out.println();

        System.out.println("Create and use for loops");
        forLoops();
        System.out.println();

        System.out.println("Create and use the enhanced for loop");
        enhancedForLoops();
        System.out.println();

        System.out.println("Create and use do/while loops");
        doWhileLoops();
        System.out.println();

        System.out.println("Use break and continue");
        breakAndContinue();
        System.out.println();
    }

    private void breakAndContinue() {
        exampleBreak();
        exampleContinue();
    }

    private void exampleContinue() {
        System.out.println("Using continue");
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            if (4 < i && i < 8) {
                continue;
            }
            sum = sum + i;
        }
        //skips 5, 6, 7
        System.out.println("sum = " + sum);
    }

    private void exampleBreak() {
        System.out.println("Using break");
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            if (4 < i && i < 8) {
                break;
            }
            sum = sum + i;
        }
        //breaks at 5
        System.out.println("sum = " + sum);
    }

    private void enhancedForLoops() {
        int[] a = {100, 200, 300, 400};
        int total = 0;
        for (int value : a) {
            total += value;
        }
        System.out.println("Sum of all the elements in the array is " + total);

        List<Integer> items = Arrays.asList(10, 20, 30, 40, 50);
        int sum = 0;
        for (Integer value : items) {
            sum += value;
        }
        System.out.println("Sum of all the elements in the list is " + sum);
    }

    private void forLoops() {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println("Sum of all integer from 1 to 100 (inclusive) is " + sum);

        int[] a = {100, 200, 300, 400};
        int total = 0;
        for (int i = 0; i < a.length; i++) {
            total += a[i];
        }
        System.out.println("Sum of all the elements in the array is " + total);
    }

    private void whileLoops() {
        Random random = new Random();
        int value;
        //if value is 0, the loop is never executed
        value = random.nextInt(10);
        int count = 0;
        while (value > 0) {
            count += 1;
            System.out.println("Random value is " + value);
            value = random.nextInt(10);
        }
        System.out.println("count = " + count);
    }

    private void doWhileLoops() {
        Random random = new Random();
        int count = 0;
        int value;
        do {
            value = random.nextInt(10);
            System.out.println("Random value is " + value);
            count += 1;

        } while (value > 0);
        System.out.println("count = " + count);
    }
}
