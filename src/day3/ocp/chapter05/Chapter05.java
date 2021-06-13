package day3.ocp.chapter05;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Chapter05 {
    public static void main(String[] args) {
        Chapter05 chapter05 = new Chapter05();
        chapter05.demo();
    }

    private void demo() {
        System.out.println("Develop code to extract data from an object using peek() and map() methods including primitive versions of the map() method");
        peekMap();
        System.out.println();

        System.out.println("Search for data by using search methods of the Stream classes including findFirst, findAny, anyMatch, allMatch, noneMatch");
        streamSearch();
        System.out.println();

        System.out.println("Develop code that uses the Optional class");
        optionalClass();
        System.out.println();

        System.out.println("Develop code that uses the Optional class");
        optionalClass();
        System.out.println();

        System.out.println("Develop code that uses Stream data methods and calculation methods");
        calculations();
        System.out.println();

        System.out.println("Sort a collection using Stream API");
        sorting();
        System.out.println();

        System.out.println("Save results to a collection using the collect method and group/partition data using the Collectors class");
        grouping();
        System.out.println();

        System.out.println("Use flatMap() methods in the Stream API");
        flatmap();
    }

    private void flatmap() {
        List<String> values1 = Arrays.asList("one", "two", "three");
        List<String> values2 = Arrays.asList("satu", "dua", "tiga");
        List<List<String>> all = Arrays.asList(values1, values2);
        System.out.println(all.size());
        List<String> joined1 = all.stream().flatMap(x -> x.stream()).collect(Collectors.toList());
        System.out.println(joined1.size());
        List<Stream<String>> joined2 = all.stream().map(x -> x.stream()).collect(Collectors.toList());
        System.out.println(joined2.size());

    }

    private void grouping() {
        List<String> nums = Arrays.asList("one", "two", "three", "four", "five", "six");
        Map<Integer, List<String>> result = nums.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(result);
    }

    private void sorting() {
        List<Integer> nums = Arrays.asList(1, 70, 6, 90, 2);
        System.out.println(nums.stream().sorted().collect(Collectors.toList()));
        System.out.println(nums.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
        System.out.println(nums.stream().sorted((o1, o2) -> o1.toString().compareTo(o2.toString())).collect(Collectors.toList()));
    }

    private void calculations() {
        IntStream s1 = IntStream.of(1, 20, 40, 5, 7);
        IntSummaryStatistics ss = s1.summaryStatistics();
        System.out.println(ss.getAverage());
        System.out.println(ss.getMin());
        System.out.println(ss.getMax());
        System.out.println(ss.getSum());
    }

    private void optionalClass() {
        Integer a = null;
        Integer b = Integer.valueOf(100);

        Optional<Integer> v1 = Optional.of(b);
        Optional<Integer> v2 = Optional.ofNullable(a);

        //using is present
        if (v1.isPresent()) {
            System.out.println("isPresent v1 = " + v1.get());
        }

        //using ifPresent
        v1.ifPresent(v -> System.out.println("ifPresent v1 = " + v));
    }

    private void streamSearch() {
        //findFirst
        List<String> nums = Arrays.asList("", "b", "c", "d", "e", "ee", "ff", "gg", "hh", "zz");
        Optional<String> r1 = nums.stream().filter(s -> s.length() == 2).parallel().findFirst();
        if (r1.isPresent()) {
            System.out.println("Found " + r1.get());
        } else {
            System.out.println("Not found");
        }

        Optional<String> r2 = nums.stream().filter(s -> s.length() > 5).parallel().findFirst();
        if (r2.isPresent()) {
            System.out.println("Found " + r2.get());
        } else {
            System.out.println("Not found");
        }

        //find any
        Optional<String> r3 = nums.stream().filter(s -> s.length() == 2).parallel().findAny();
        if (r3.isPresent()) {
            System.out.println("Found " + r3.get());
        } else {
            System.out.println("Not found");
        }

        //anyMatch
        System.out.println("anyMatch");
        System.out.println(nums.stream().anyMatch(s -> s.startsWith("e")));
        System.out.println(nums.stream().anyMatch(s -> s.startsWith("x")));

        //allMatch
        System.out.println("allMatch");
        System.out.println(nums.stream().allMatch(s -> s.length() > 40));
        System.out.println(nums.stream().allMatch(s -> s.length() < 40));

        //noneMatch
        System.out.println("noneMatch");
        System.out.println(nums.stream().noneMatch(s -> s.length() > 40));
        System.out.println(nums.stream().noneMatch(s -> s.length() < 40));

    }

    private void peekMap() {
        //object
        List<Integer> nums = Arrays.asList(1, 20, 70, 19, 12);
        long count;
        System.out.println("Peek #1");
        count = nums.stream().peek(System.out::println).filter(n -> n > 15).count();
        System.out.println("count = " + count);
        System.out.println("Peek #2");
        count = nums.stream().filter(n -> n > 15).peek(System.out::println).count();
        System.out.println("count = " + count);
        System.out.println("Peek #3");
        nums.stream().filter(n -> n > 15).peek(System.out::println);

        System.out.println("Map #1");
        nums.stream().map(n -> n + 1_000);
        System.out.println(nums);

        System.out.println("Map #2");
        List<String> items = nums.stream().map(n -> "#" + n + "#").collect(Collectors.toList());
        System.out.println(items);

        //primitiveMap
        System.out.println(Arrays.toString(IntStream.range(1, 5).toArray()));
        count = IntStream.range(1, 5).map(n -> n % 2).filter(n -> n == 0).count();
        System.out.println("count = " + count);
    }
}
