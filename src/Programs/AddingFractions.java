package Programs;

/**
 * Created by NISHANT on 3/16/18.
 */
public class AddingFractions {

    public int numerator;
    public int denominator;

    public AddingFractions(int n, int d){
        this.numerator = n;
        this.denominator = d;
    }

    public static void main(String[] args) {

        AddingFractions f1 = new AddingFractions(3, 4);
        AddingFractions f2 = new AddingFractions(5, 6);

        System.out.println(print(f1));
        System.out.println(print(f2));

        int deno = f1.denominator * f2.denominator;
        System.out.println(deno);

        int nume = (f1.numerator*f2.denominator) + (f2.numerator*f1.denominator);
        System.out.println(nume);

        AddingFractions f3 = new AddingFractions(nume, deno);
        System.out.println(print(f3));

    }

    private static String print(AddingFractions f1) {

        return f1.numerator + "/" + f1.denominator;
    }


}


