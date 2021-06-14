package day3.ocp.chapter08;

import java.io.Console;

public class Chapter08 {
    public static void main(String[] args) {
        Chapter08 chapter08 = new Chapter08();
        chapter08.demo();
    }

    private void demo() {
        System.out.println("Read and write data from the console");
        readConsole();
        System.out.println();
    }

    private void readConsole() {
        Console c = System.console();
        String s = c.readLine();
        System.out.println("input was -> " + s);
    }
}
