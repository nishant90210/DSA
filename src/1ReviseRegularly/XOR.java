package TopInterviewQuestions;

public class XOR {

    /*
        1) XOR of any number n with itself gives us 0, i.e., n ^ n = 0
        2) XOR of any number n with 0 gives us n, i.e., n ^ 0 = n
        3) XOR is cumulative and associative.
    */
    public static int findBits(int x, int y)
    {
        return (x | y) - (x & y);
    }

    public static void main(String[] args)
    {
        int x = 7;
        int y = 9;

        // "|" also known as OR
        System.out.println("First number in binary is  " + Integer.toBinaryString((x | y)));
        // "&" also known as AND
        System.out.println("Second number in binary is " + Integer.toBinaryString((x & y)));

        // XOR = OR - AND
        System.out.println("\nXOR is " + Integer.toBinaryString(findBits(x, y)));
    }
}
