package day1.chapter01;

import java.util.Random;

public class Lab01b {
    public static void main(String[] args) {
        Random random = new Random();
        System.out.println("Random number between 0 to 99: " + random.nextInt(100));
    }
}
