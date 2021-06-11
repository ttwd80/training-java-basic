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

        System.out.println("Index is zero based");
        zeroBasedIndex();
        System.out.println();

        System.out.println("Default element value");
        defaultElementValue();
    }

    private void defaultElementValue() {
        int[] a = new int[10];
        Integer[] b = new Integer[10];
        System.out.println("a[5] = " + a[5]);
        System.out.println("b[5] = " + b[5]);
    }

    private void zeroBasedIndex() {
        int[] a = {63, 88, 54, 92};
        System.out.println("a[1] = " + a[1]);
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
