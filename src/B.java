/**
 * Created by NISHANT on 6/25/18.
 */

// Overriding in Java simply means that the particular method would be called based on the run time type of the object and
// not on the compile time type of it (which is the case with overriden static methods).
// So you can’t override static method.
// Static methods are class methods not object.

// If we remove the static keyword from the method then
//    A a = new B(); will print the B's method
// But with static keyword override will not happen and we will get the A's method.

class A{
    public static void staticMethod() {
        System.out.println("SuperClass: inside staticMethod");
    }
}

public class B extends A{

    //overriding the static method
    public static void staticMethod() {
        System.out.println("SubClass: inside staticMethod");
    }

    public static void main(String []args){

        A AWithSuperCons = new A();
        A AWithSubCons = new B();
        B BWithSubCons = new B();

        AWithSuperCons.staticMethod();
        AWithSubCons.staticMethod();
        BWithSubCons.staticMethod();
    }
}