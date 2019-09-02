package Programs;

public class CalculatePower {

    public static void main(String[] args) {

        int a = 2;
        int b = 8;
        int power = power(a, b);
        System.out.println(power);
//        int power = 1;
//        for(int i = 1; i <= b; i++){
//            power = a * power;
//        }
//        System.out.println(power);
    }

    private static int power(int a, int b) {

        //This will reduce the problem to a^b/2 means a^8, a^4, a^2 ...
        int result;
        if (b == 0){
            return 1;
        }
        result = power(a , b/2);
        if (b % 2 == 0){
            return result*result;
        }else {
            return a*result*result;
        }
    }
}
