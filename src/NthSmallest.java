public class NthSmallest {

    public static void main(String[] args) {

        System.out.println(solution(28));
    }

    public static int solution(int N) {
        // write your code in Java SE 8
        int sumOfN = 0;
        int originalNumber = N;
        sumOfN = getSum(N);
        for (int i = originalNumber+1; i < 50000; i++) {
            int sum = getSum(i);
            if(sum == sumOfN) {
                return i;
            }
        }
        return sumOfN;
    }

    private static int getSum(int n) {
        int result = 0;
        while(n > 0) {
            result += n % 10;
            n = n / 10;
        }
        return result;
    }
}
