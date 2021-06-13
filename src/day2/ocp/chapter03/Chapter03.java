package day2.ocp.chapter03;

import java.util.*;

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
        demoDataStructure();


    }

    private void demoDataStructure() {
        List<String> a = new ArrayList<>();
        a.add("1");
        a.add("2");
        a.add("30");
        a.add("40");
        a.remove(2);
        System.out.println(a);


        List<Integer> b = new ArrayList<>();
        b.add(1);
        b.add(2);
        b.add(30);
        b.add(40);
        b.remove(2);
        System.out.println(b);

        List<Integer> c = new ArrayList<>();
        c.add(Integer.valueOf(1));
        c.add(Integer.valueOf(2));
        c.add(Integer.valueOf(30));
        c.add(Integer.valueOf(40));
        c.remove(Integer.valueOf(2));
        System.out.println(c);

        Set<Integer> d = new HashSet<>();
        d.add(1);
        d.add(20);
        d.add(5);
        d.add(60);
        d.add(5);
        d.add(900);
        d.add(1);
        System.out.println(d);

        Set<Integer> e = new TreeSet<>();
        e.add(1);
        e.add(20);
        e.add(5);
        e.add(60);
        e.add(5);
        e.add(900);
        e.add(1);
        System.out.println(e);

        Map<String, String> map1 = new LinkedHashMap<>();
        map1.put("my", "Malaya");
        map1.put("sg", "Singapore");
        map1.put("nz", "New Zealand");
        map1.put("my", "Malaysia");
        map1.put("au", "Australia");
        System.out.println(map1);

        Map<String, String> map2 = new TreeMap<>();
        map2.put("my", "Malaya");
        map2.put("sg", "Singapore");
        map2.put("nz", "New Zealand");
        map2.put("my", "Malaysia");
        map2.put("au", "Australia");
        System.out.println(map2);

        Deque<Integer> q1 = new ArrayDeque<>();
        q1.addAll(Arrays.asList(1, 20, 50, 20, 1, 200, 70, 1, 50));
        System.out.println("Peek");
        System.out.println(q1);
        System.out.println(q1.peek());
        System.out.println(q1.peek());
        System.out.println("peekFirst");
        System.out.println(q1);
        System.out.println(q1.peekFirst());
        System.out.println(q1.peekFirst());
        System.out.println("peekLast");
        System.out.println(q1);
        System.out.println(q1.peekLast());
        System.out.println(q1.peekLast());

        // https://docs.oracle.com/javase/8/docs/api/java/util/Deque.html

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
