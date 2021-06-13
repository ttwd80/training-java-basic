package day2.ocp.chapter03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Chapter03 {
    public static void main(String[] args) {
        Chapter03 chapter03 = new Chapter03();
        chapter03.demo();
    }

    private void demo() {
        System.out.println("Create and use a generic class");
        demoGenerics();
        System.out.println();

        System.out.println("Create and use ArrayList, TreeSet, TreeMap, and ArrayDeque objects");
        //sambung besok


    }

    static class Weave<T, U> {
        void process(List<T> t, List<U> u, int count) {
            for (int i = 0; i < count; i++) {
                System.out.println(t.get(i));
                System.out.println(u.get(i));
            }
        }
    }

    private void demoGenerics() {
        List<Integer> a = Arrays.asList(1, 50, 42, 88);
        List<String> b = Arrays.asList("a", "b", "c", "d");
        Weave<Integer, String> w = new Weave<>();
        w.process(a, b, 2);

        //the old way
        List o1 = new ArrayList();
        o1.add(new Integer(33));
        o1.add("xxx");
        o1.add(new Double("1.22"));


    }
}
