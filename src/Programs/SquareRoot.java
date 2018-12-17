package Programs;

/**
 * Created by Nishant on Dec, 2018
 */
public class SquareRoot {

    public static void main(String[] args) {

        double x = 11;
        System.out.println(floorSqrt(x));
//        findSquareRoot(x);
//        System.out.println(Math.sqrt(x));
    }


//    public static void findSquareRoot(double number)
//    {
//
//        double g1;
//
//        if(number==0) {
//            System.out.println("Square root of "+number+" = "+0);
//        }
//
//        double squareRoot = number/2;
//        do {
//            g1=squareRoot;
//            squareRoot = (g1 + (number/g1))/2;
//        }
//        while((g1-squareRoot)!=0);
//
//        System.out.println("Square roots of "+number+" are ");
//        System.out.println(squareRoot);
//
//    }

    private static double floorSqrt(double x) {

        if (x == 0 || x ==1){
            return x;
        }
        double start = 0, end = x, ans = 0;
        while (start <= end){
            double mid = (start+end)/2;
            if (mid * mid == x){
                return mid;
            }
            if (mid*mid < x)
            {
                start = mid;
                ans = mid;
            }
            else{
                end = mid;
                ans = mid;
            }
        }
        return ans;
    }
}
