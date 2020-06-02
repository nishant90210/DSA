package Programs;

public class DecimalToBinary {

    public static void main(String[] args) {

        int m = 4;
        int n = 8;
        int quotient = 0;
        int result = 0;
        result = decimalToBinary(m, quotient);
        for(int i = m+1; i <= n; i++){
            int binaryVal = decimalToBinary(i, quotient);
            result = result & binaryVal;
        }
        result = binaryTodecimal(~5);
        System.out.println(result);
    }

    private static int decimalToBinary(int i, int quotient) {

        int onceAndTensPlace = 1;
        while (i > 0) {
            quotient = i % 2 * onceAndTensPlace + quotient;
            i = i / 2;
            onceAndTensPlace = onceAndTensPlace * 10;
        }
        return quotient;
    }

    private static int binaryTodecimal(int result) {

        double answer = 0;
        int power = 0;
        while (result > 0){
            int remainder = result % 2;
            double pow = Math.pow(2, power);
            answer = answer + (remainder * pow);
            power++;
            result = result / 10;
        }
        return (int) answer;
    }
}
