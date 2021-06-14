package day3.ocp.chapter10;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Chapter10 {
    public static void main(String[] args) {
        Chapter10 chapter10 = new Chapter10();
        chapter10.demo();
    }

    private void demo() {
        System.out.println("Create worker threads using Runnable, Callable and use an ExecutorService to concurrently execute tasks");
        demoRunnable();
        System.out.println();

        System.out.println("Identify potential threading problems among deadlock, starvation, livelock, and race conditions");
        //thread-a locks resource-500
        //thread-b locks resource-100
        //thread-a tries to lock a resource-100
        //but fails because, thread-b, is locking it
        //so thread-a kena tunggu
        //in the mean time, thread b tries to lock resource-500
        //tapi thread-a is locking it, so thread-b kena tunngu
        //dua dua kena tunggu
        //dua dua tak boleh progress
        demoRaceCondition();
        System.out.println();

        System.out.println("Use synchronized keyword and java.util.concurrent.atomic package to control the order of thread execution");
        demoAtomic();

    }

    static class Lines {
        public void print() {
            System.out.println("line #1");
            System.out.println("line #2");
            System.out.println("line #3");
            System.out.println("line #4");
            System.out.println("line #5");
        }
    }
    static class SyncLines {
        public synchronized void  print() {
            System.out.println("sline #1");
            System.out.println("sline #2");
            System.out.println("sline #3");
            System.out.println("sline #4");
            System.out.println("sline #5");
        }
    }
    private void demoAtomic() {
        AtomicInteger value = new AtomicInteger(0);
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Callable<Object> c = () -> {
            value.addAndGet(10);
            return null;
        };

        Callable<Object> d = () -> {
            Lines lines = new Lines();
            lines.print();
            return null;
        };
        Callable<Object> e = () -> {
            SyncLines lines = new SyncLines();
            lines.print();
            return null;
        };


        List<Callable<Object>> r1 = Arrays.asList(c,c,c,c,c,c,c,c);
        List<Callable<Object>> r2 = Arrays.asList(d,d,d);
        List<Callable<Object>> r3 = Arrays.asList(e,e,e);
        try {
            executorService.invokeAll(r1);
            executorService.invokeAll(r2);
            executorService.invokeAll(r3);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("atomic = " + value.get());

        executorService.shutdown();


    }

    static class Counter {
        private int count = 0;

        public Counter() {

        }

        public void add(int n) {
            int oldValue = this.count;
            System.out.println("***");
            int newValue = oldValue + n;
            this.count = newValue;
        }

        public int get() {
            return count;
        }
    }

    private void demoRaceCondition() {
        //non threading
        Counter a = new Counter();
        a.add(10);
        a.add(20);
        System.out.println("a = " + a.get());

        Counter b = new Counter();
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Callable<Object> c = () -> {
            b.add(10);
            return null;
        };
        List<Callable<Object>> runs = Arrays.asList(c,c,c,c,c,c,c,c);
        try {
            executorService.invokeAll(runs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("b = " + b.get());
        executorService.shutdown();

    }

    private void demoRunnable() {
        Runnable r1 = () -> System.out.println("123");
        Runnable r2 = () -> System.out.println("200");
        Runnable r3 = () -> System.out.println("300");
        Runnable r4 = () -> System.out.println("400");

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(r1);
        executorService.submit(r2);
        executorService.submit(r3);
        executorService.submit(r4);

        Callable<Integer> c1 = () -> {
            System.out.println("c1");
            return 1000;
        };
        Callable<Integer> c2 = () -> {
            System.out.println("c2");
            return 200;
        };
        Callable<Integer> c3 = () -> {
            System.out.println("c3");
            return 3;
        };
        Callable<Integer> c4 = () -> {
            System.out.println("c4");
            return 4000;
        };
        List<Callable<Integer>> items = Arrays.asList(c1, c2, c3, c4);
        try {
            List<Future<Integer>> futures = executorService.invokeAll(items);
            for (Future<Integer> f : futures) {
                System.out.println("result of future: " + f.get());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
