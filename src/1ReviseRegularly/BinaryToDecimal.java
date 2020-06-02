package TopInterviewQuestions;

public class BinaryToDecimal {

    public static void main(String args[]){

        System.out.println("Decimal of 1010 is: "+getDecimal(1110));
        System.out.println("Decimal of 10101 is: "+getDecimal(10101));
        System.out.println("Decimal of 11111 is: "+getDecimal(11111));
    }

    private static int getDecimal(int binary) {

        int power = 0, temp, decimal = 0;

        while (binary > 0){
            temp = binary % 10;
            decimal += temp * Math.pow(2, power);
            power++;
            binary = binary / 10;
        }
        return decimal;
    }
}
