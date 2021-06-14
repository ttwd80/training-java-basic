package day3.ocp.chapter06;

import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Chapter06 {
    public static void main(String[] args) {
        Chapter06 chapter06 = new Chapter06();
        chapter06.demo();
    }

    private void demo() {
        System.out.println("Use try-catch and throw statements");
        System.out.println("Use catch, multi-catch, and finally clauses");

        System.out.println("Use Autoclose resources with a try-with-resources statement");
        autoclose();
        System.out.println();

        System.out.println("Create custom exceptions and Auto-closeable resources");
        autocloseResource();
        System.out.println();

        System.out.println("Test invariants by using assertions");
        usingAssert();
    }

    private void usingAssert() {
        int a = 10;
        assert(a == 10);
        System.out.println("so far so good");

        a = 20;
        assert(a == 30);
        System.out.println("this is unreachable");
    }

    static class A implements Closeable {

        @Override
        public void close() throws IOException {
            System.out.println("A.close()");
        }

        public void doNothing() {
            System.out.println("A.doNothing()");
        }

        public void doSomethingBad() throws IOException {
            throw new IOException("hardware error");
        }
    }

    private void autocloseResource() {
        try (A a = new A()) {
            a.doNothing();
            a.doSomethingBad();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void autoclose() {
        autocloseOldWay();
        autocloseTryResource();

    }

    private void autocloseTryResource() {
        try (ByteArrayInputStream in = new ByteArrayInputStream("sample input".getBytes(StandardCharsets.UTF_8))) {
            byte[] buffer = new byte[100];
            int count = in.read(buffer);
            System.out.println("bytes read = " + count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void autocloseOldWay() {
        ByteArrayInputStream in = null;
        try {
            in = new ByteArrayInputStream("sample input".getBytes(StandardCharsets.UTF_8));
            byte[] buffer = new byte[100];
            int count = in.read(buffer);
            System.out.println("bytes read = " + count);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
