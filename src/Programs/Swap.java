package Programs;

/**
 * Created by NISHANT on 4/10/18.
 */
public class Swap {

    public static void main(String[] args) {

        Integer a = 7;
        Integer b = 5;

        a = a+ b;
        b = a -b;
        a = a -b;

        System.out.println("a " + a);
        System.out.println("b " + b);


    }
}
