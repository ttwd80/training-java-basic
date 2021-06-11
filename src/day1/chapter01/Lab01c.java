package day1.chapter01;

public class Lab01c {
    private int a;
    private int b;
    private static int c;

    public static void main(String[] args) {
        Lab01c lab = new Lab01c();
        lab.objectScopeAndFunctionScope();
        System.out.println();
        lab.classScopeAndObjectScope();
        System.out.println();
        lab.hiddenVariable();

    }

    private void hiddenVariable() {
        System.out.println("Hidden Variable");
        Lab01c lab = new Lab01c();
        lab.a = 10;
        lab.overlap1(20);
        System.out.println("a = " + lab.a);
        lab.overlap1(30);
        System.out.println("a = " + lab.a);
        lab.overlap2(40);
        System.out.println("a = " + lab.a);
        lab.overlap2(50);
        System.out.println("a = " + lab.a);
    }

    void overlap2(int a) {
        this.a = a;
    }

    void overlap1(int a) {
        a = a;
    }

    private void classScopeAndObjectScope() {
        System.out.println("Class Scope and Object Scope");
        Lab01c x = new Lab01c();
        Lab01c y = new Lab01c();
        x.a = 10;
        y.a = 20;
        System.out.println("x.a = " + x.a + ", y.a = " + y.a);
        x.c = 100;
        y.c = 200;
        System.out.println("x.c = " + x.c + ", y.c = " + y.c);

    }

    private void objectScopeAndFunctionScope() {
        System.out.println("Object Scope and Function Scope");
        init(0, 0);
        display();
        init(20, 20);
        display();
        init(30, 30);
        display();
    }

    void init(int x, int y) {
        a = x;
        b = y;
    }

    void display() {
        int b = 10;
        System.out.println("a = " + a + ", b = " + b);
    }
}
