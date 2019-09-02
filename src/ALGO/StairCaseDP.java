package ALGO;

//Help : https://www.youtube.com/watch?v=NFJ3m9a1oJQ
//O(1.62^n) == O(2^n)
public class StairCaseDP {

    public static void main (String args[])
    {
        int s = 4;
//        System.out.println("Number of ways = "+ countWays(s));
        int totalWays = countWaysMemo(s);
        System.out.println("Number of ways = "+ totalWays);
    }

    //Bottom-Down approach
    private static int countWaysMemo(int s) {

        int[] ways = new int[s+1];
        ways[0] = 1;
        ways[1] = 1;
        for(int i = 2; i <= s; i++){
            ways[i] = ways[i-1] + ways[i-2];
        }
        return ways[s];
    }

    //Top-Down approach
    private static int countWays(int s) {

        return fib(s+1);
    }

    private static int fib(int s) {

        if (s <= 1){
            return s;
        } else {
            return fib(s-1) + fib(s-2);
        }
    }
}
