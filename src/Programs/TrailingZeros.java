package Programs;

/**
 * Created by NISHANT on 6/1/18.
 */
public class TrailingZeros {

    public static void main(String[] args) {

        int n = 100;
        int i = 5;
        int res = 0;
        while (i <= n){
            res += n / i;
            i = i * 5;
        }
        System.out.println("Number of trailing zeros are :- " + res);
    }
}
