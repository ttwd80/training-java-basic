package day1.chapter04;

public class Lab04 {
    public static void main(String[] args) {
        Lab04 lab = new Lab04();
        lab.demo();
    }

    private void demo() {
        //Minimum array primitive and object
        System.out.println("Create an array of size 0");
        createMinimum();
        System.out.println();

        System.out.println("Create an array of size 1_000_000");
        createMillion();
        System.out.println();
    }

    private void createMillion() {
        int[] a = new int[1_000_000];
        Integer[] b = new Integer[1_000_000];
        System.out.println("a.length = " + a.length);
        System.out.println("b.length = " + b.length);
    }

    private void createMinimum() {
        int[] a = new int[0];
        Integer[] b = new Integer[0];
        System.out.println("a.length = " + a.length);
        System.out.println("b.length = " + b.length);
    }
}
