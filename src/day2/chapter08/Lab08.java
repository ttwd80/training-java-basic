package day2.chapter08;

public class Lab08 {
    public static void main(String[] args) {
        Lab08 lab = new Lab08();
        lab.demo();
    }

    private void demo() {
        System.out.println("Differentiate among checked exceptions, unchecked exceptions, and Errors");
        checkedUncheckedErrors();
    }

    private void checkedUncheckedErrors() {
        checkedExceptions();
    }

    private void checkedExceptions() {
        //method 1 declares it will throw an exception, so we must handle it
        try {
            method1();
        } catch (ExceptionA e) {
        }

        //method1 declares it will throw an exception
        //we have 2 catch blocks
        //method1 has a specific catch block for a subclass
        //subclass should appear before the parent class
        try {
            method1();
        }catch (ExceptionD e) {

        }catch (ExceptionA e) {

        }


        //method 2 declares it will throw an exception, so we must handle it
        try {
            method2();
        } catch (ExceptionB e) {
        }

        //method 3 declares it will throw an exception, so we must handle it
        try {
            method3();
        } catch (ExceptionA e) {
        }

        //method 4 throws multiple exceptions
        //our code must catch all of them
        //option1: catch each one in its own block
        try {
            method4();
            //ExceptionD extends ExceptionA, so ExceptionD must be caught first
        } catch (ExceptionD e) {
        } catch (ExceptionA e) {
        } catch (ExceptionB e) {
        } catch (ExceptionC e) {
        }

        //method 4 throws multiple exceptions
        //our code must catch all of them
        //option2: group some of them together if they have similar handling code
        try {
            method4();
        } catch (ExceptionD exceptionA) {
        } catch (ExceptionA|ExceptionB|ExceptionC e) {
        }

        //method 4 throws multiple exceptions
        //our code must catch all of them
        //option3: remove code for handling the subclass ExceptionD
        //this is valid because we already handled the parent class ExceptionA
        try {
            method4();
        } catch (ExceptionA e) {
        } catch (ExceptionB e) {
        } catch (ExceptionC e) {
        }

        //method 4 throws multiple exceptions
        //our code must catch all of them
        //option3: remove code for handling the subclass ExceptionD
        //this is valid because we already handled the parent class ExceptionA
        try {
            method4();
        } catch (ExceptionA e) {
        } catch (ExceptionB e) {
        } catch (ExceptionC e) {
        }

        //method 4 throws multiple exceptions
        //our code must catch all of them
        //option4: use one catch to catch all
        //this should be used as a last resort
        //All exceptions extends java.lang.Exception
        //if you catch the base class, you don't have to catch the subclass
        try {
            method4();
        } catch (Exception e) {
        }

        //method 4 throws multiple exceptions
        //our code must catch all of them
        //option5: handle some of the exceptions individually
        //and have a general one at the bottom
        try {
            method4();
        } catch (ExceptionD e) {
        } catch (ExceptionB e) {
        } catch (Exception e) {
        }

    }

    //method1 declares it will throw an exception
    //it can choose to throw and exception
    //or it can choose not to throw an exception
    private void method1() throws ExceptionA {
    }

    //method2 declares it will throw an exception
    //it can choose to throw and exception
    //or it can choose not to throw an exception
    private void method2() throws ExceptionB {
        throw new ExceptionB();
    }

    //method3 declares it will throw an exception
    //notice that it is throwing a different class than the one declared
    //this is fine, we can throw the subclass of the declared exception
    private void method3() throws ExceptionA {
        throw new ExceptionD();
    }


    //method4 declares it will throw multiple exceptions
    //it can throw all of then
    //it can throw none of them
    //it can throw some of them
    private void method4() throws ExceptionA, ExceptionB, ExceptionC, ExceptionD{
        throw new ExceptionA();
    }

}
