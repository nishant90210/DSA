package Arrays;

/**
 * Created by NISHANT on 11/16/17.
 */
public class LargestSumContiguousSubarray {

    //Kadane Alog
    public static void main (String[] args)
    {
        int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum contiguous sum is " + maxSubArraySum(a));
        System.out.println("Maximum contiguous sum in Quadratic Time " + maxSubArraySumQuadraticTime(a));
    }

    private static int maxSubArraySumQuadraticTime(int[] nums) {

        int n = nums.length;
        int maximumSubArraySum = Integer.MIN_VALUE;

        for (int left = 0; left < n; left++) {
            int runningWindowSum = 0;
            for (int right = left; right < n; right++) {
                runningWindowSum += nums[right];
                maximumSubArraySum = Math.max(maximumSubArraySum, runningWindowSum);
            }
        }
        return maximumSubArraySum;
    }

    private static int maxSubArraySum(int[] nums) {

        int maxSoFar = nums[0], maxEndingHere = nums[0];
        for (int i = 1; i < nums.length; i++){
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
        }
        return maxSoFar;
    }
}
