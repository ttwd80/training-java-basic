package day2.chapter09;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lab09 {
    public static void main(String[] args) {
        Lab09 lab = new Lab09();
        lab.demo();
    }

    private void demo() {
        System.out.println("Manipulate data using the StringBuilder class and its methods");
        sb();
        System.out.println();

        System.out.println("Create and manipulate Strings");
        manipulateString();
        System.out.println();

        System.out.println("Create and manipulate calendar data using classes from java.time.LocalDateTime,  java.time.LocalDate, java.time.LocalTime, java.time.format.DateTimeFormatter, java.time.Period");
        dateTimeAPI();
        System.out.println();

        System.out.println("Declare and use an ArrayList of a given type");
        genericsArrayList();
        System.out.println();

        System.out.println("Write a simple Lambda expression that consumes a Lambda Predicate expression");
        showLambda();
    }

    /*
    static class ReverseCompare implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }
     */

    private void showLambda() {
        List<Integer> a = new ArrayList<>();
        a.add(40);
        a.add(37);
        a.add(50);
        a.add(200);
        a.add(66);

        //Collections.sort(a);
        //Collections.sort(a, new ReverseCompare());
        Collections.sort(a, (o1, o2) -> o2 - o1);

        //start
        List<Integer> result = new ArrayList<>();
        for (Integer v: a) {
            if (v > 50) {
                result.add(v);
            }
        }
        //end


        //replacement
        List<Integer> b = a.stream().filter(x -> x > 50).collect(Collectors.toList());

        System.out.println(a);
        System.out.println(b);
        System.out.println(result);

    }

    private void genericsArrayList() {
        //simple use of array list
        List<Integer> a = new ArrayList<>();
        //allow for random access, just like normal array
        //if we have 10,000 elements, and we want to access, element number 9,000
        //we can just access it a[9000]
        a.add(10);
        a.add(20);
        a.add(30);
        a.get(2);

        //1,2,3,.....10,000
        //kita nak add one element in the middle, at index, 4000
        //if it is an array list,
        //create a new array list
        //copy element 1 to 3,999,
        //copy new data
        //copy element 4,000 - 10,000
        //[1][2][3]
        System.out.println(a);

        List<Integer> b = new LinkedList<>();
        //sequential access
        //if we have 10,000 elements, and we want to access element number 9,000
        //we have to access all the elements before it

        b.add(10);
        b.add(20);
        b.add(30);
        b.get(2);

        //kita nak add one element in the middle, at index, 4000
        //if it is an linked list
        //current value, points to index 4,001
        //element 4,000 points to new element
        System.out.println(b);


        List<Number> c = new ArrayList<>();
        c.add(new Integer(10));
        c.add(new Double("1.12"));
        c.add(new Long("30"));
        for (Number n : c) {
            System.out.println(n);
        }

        List<Integer> d = new ArrayList<>();
        d.add(new Integer("4"));


    }

    private void dateTimeAPI() {
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        LocalDate ld = LocalDate.now();
        System.out.println(ld);

        System.out.println();
        LocalDate first = LocalDate.of(2020, 1,1);
        System.out.println(LocalDate.now().isAfter(first));

    }

    private void manipulateString() {
        String s = "abcdef";
        s.toCharArray();
        s.getBytes(StandardCharsets.UTF_8);
        System.out.println("\uD83D\uDC7D");
    }

    private void sb() {
        String abc = "abc";
        System.out.println(abc + "def");
        System.out.println(abc);
        abc = abc + "def";
        System.out.println(abc);

        final StringBuilder s = new StringBuilder();
        s.append("abc");
        s.append("def");
        s.insert(2, "x");
        System.out.println("s = " + s.toString());
    }
}
