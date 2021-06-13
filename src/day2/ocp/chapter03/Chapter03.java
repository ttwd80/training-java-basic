package day2.ocp.chapter03;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Stream;

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
        System.out.println();

        System.out.println("Use java.util.Comparator and java.lang.Comparable interfaces");
        demoCompare();
        System.out.println();

        System.out.println("Collections Streams and Filters");
        demoStreamFilter();
        System.out.println();

        System.out.println("Iterate using forEach methods of Streams and List");
        demoForEach();
        System.out.println();

        System.out.println("Describe Stream interface and Stream pipeline");
        System.out.println("Filter a collection by using lambda expressions");
        System.out.println("Use method references with Streams");
        demoMethod();
    }

    private void demoMethod() {
        Consumer<String> c = s -> System.out.println(s + " -> " + s.length());
        List<String> a = Arrays.asList("Cat", "Cattle", "Dog", "Apple", "Ball", "Bat", "Mouse", "Corn");
        a.stream().forEach(c);
    }

    private void demoForEach() {
        List<String> a = Arrays.asList("Cat", "Cattle", "Dog", "Apple", "Ball", "Bat", "Mouse", "Corn");
        a.stream().forEach(s -> System.out.println(s + " -> " + s.length()));

    }

    private void demoStreamFilter() {
        List<String> a = Arrays.asList("Cat", "Cattle", "Dog", "Apple", "Ball", "Bat", "Mouse", "Corn");
        System.out.println("No terminal method");
        a.stream().filter(s -> s.length() > 3).filter(s -> s.startsWith("C")).
                map(s -> new StringBuilder(s).reverse().toString()).peek(s -> System.out.println(s));
        System.out.println("Terminal count");
        a.stream().filter(s -> s.length() > 3).filter(s -> s.startsWith("C")).
                map(s -> new StringBuilder(s).reverse().toString()).peek(s -> System.out.println(s)).count();

        //bad stream
        Stream<String> s1 = a.stream();
        s1.filter(s -> s.startsWith("C"));
        // error
        // stream has already been operated upon or closed
        // System.out.println(s1.count()); ;

        Stream<String> s2 = a.stream();
        s2 = s2.filter(s -> s.startsWith("C"));
        // error
        System.out.println(s2.count()); ;
    }

    static class Billionaire implements Comparable<Billionaire> {
        private String name;
        //long can go up to 9 quadrillion, that is 9 followed by 12 zeroes
        private long worth;

        public Billionaire(String name, long worth) {
            this.name = name;
            this.worth = worth;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getWorth() {
            return worth;
        }

        public void setWorth(long worth) {
            this.worth = worth;
        }

        @Override
        public int compareTo(Billionaire o) {
            if (worth == o.worth) {
                return 0;
            } else if (worth > o.worth) {
                return 1;
            } else {
                return -1;
            }
        }

        @Override
        public String toString() {
            return "Billionaire{" +
                    "name='" + name + '\'' +
                    ", worth=" + worth +
                    '}';
        }
    }

    static class Country {
        private String name;
        private String capital;

        public Country(String name, String capital) {
            this.name = name;
            this.capital = capital;
        }

        public String getName() {
            return name;
        }

        public String getCapital() {
            return capital;
        }

        @Override
        public String toString() {
            return "Country{" +
                    "name='" + name + '\'' +
                    ", capital='" + capital + '\'' +
                    '}';
        }
    }


    private void demoCompare() {
        List<Billionaire> a = new ArrayList<>();
        // https://en.wikipedia.org/wiki/The_World%27s_Billionaires#2021
        // June 2021
        a.add(new Billionaire("Bill Gates",124_000_000_000L));
        a.add(new Billionaire("Mark Zuckerberg",97_000_000_000L));
        a.add(new Billionaire("Jeff Bezos",177_000_000_000L));
        a.add(new Billionaire("Elon Musk",151_000_000_000L));
        a.add(new Billionaire("Bernard Arnault & family",150_000_000_000L));

        //lets sort, comparator not defined, but class implements comparable
        System.out.println(a);
        Collections.sort(a);
        System.out.println(a);

        List<Country> b = new ArrayList<>();
        b.add(new Country("Thailand", "Bangkok"));
        b.add(new Country("Malaysia", "KL"));
        b.add(new Country("Singapore", "Singapore"));
        b.add(new Country("Japan", "Tokyo"));
        System.out.println(b);

        //sort b, error
        //reason: no instance(s) of type variable(s) T exist so that Country conforms to Comparable<? super T>
        //System.out.println(b);
        //Collections.sort(b);
        //System.out.println(b);

        //we need a comparator to sort something that is not comparable
        System.out.println("using comparator 1");
        Comparator<Country> comparator1 = (o1, o2) -> o1.name.compareTo(o2.name);
        Collections.sort(b, comparator1);
        System.out.println(b);

        System.out.println("using comparator 2");
        Comparator<Country> comparator2 = (o1, o2) -> o1.capital.compareTo(o2.capital);
        Collections.sort(b, comparator2);
        System.out.println(b);

        System.out.println("billionaire by worth");
        System.out.println(a);
        Comparator<Billionaire> comparator3 = (o2, o1) -> o1.name.compareTo(o2.name);
        Collections.sort(a, comparator3);
        System.out.println("billionaire by name, reverse");
        System.out.println(a);



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
