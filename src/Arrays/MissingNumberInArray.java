package Arrays;

/**
 * Created by NISHANT on 11/15/17.
 */
public class MissingNumberInArray {

    public static void main(String args[])
    {
        int a[] = {1,2,4,5,6};
        int length = a.length;
        int miss = getMissingNoBySum(a, length);
        int missXor = getMissingNoBySumXOR(a, 6);
        System.out.println(missXor);
    }

    private static int getMissingNoBySumXOR(int[] a, int range) {

        int total= 0, sum = 0;
        for (int i = 0; i < a.length; i++) {
            total = total ^ a[i];
        }
        for (int i = 1; i <= range; i++) {
            sum = sum ^ i;
        }
        return (total ^ sum);
    }

    private static int getMissingNoBySum(int[] a, int n) {

        int total = 0;
        int sum = ((n) * (n + 1)) / 2;
        for (int i = 0; i < n; i++) {
            total += a[i];
        }
        return total-sum;
    }
}
