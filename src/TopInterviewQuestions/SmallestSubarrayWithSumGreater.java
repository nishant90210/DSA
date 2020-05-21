package TopInterviewQuestions;

/**
 * Created by NISHANT on 4/2/18.
 */
public class SmallestSubarrayWithSumGreater {
// similar concept as MinimumWindowSubstring
    public static void main(String[] args)
    {
//        int arr[] = {2, 3, 1, 1, -1, 3, 4};
//        int target = 7;
        int arr[] = {1, 2, 3, 4};
        int target = 6;
//        int arr[] = {1, 4, 4};
//        int target = 4;
//        int arr[] = {2,3,1,2,4,3};
//        int target = 7;
        int length = arr.length;
        int res = smallestSubWithSum(arr, length, target);
        System.out.println(res);
    }

    private static int smallestSubWithSum(int[] nums, int length, int target) {
        //Works for positive numbers only
        int leftStart = 0, min = Integer.MAX_VALUE, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target){
                min = Math.min(min, i - leftStart + 1);
                sum -= nums[leftStart];
                leftStart++;
            }
        }
        return min;
    }
}
