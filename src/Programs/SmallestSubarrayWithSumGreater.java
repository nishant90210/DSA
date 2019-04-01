package Programs;

/**
 * Created by NISHANT on 4/2/18.
 */
public class SmallestSubarrayWithSumGreater {

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

    private static int smallestSubWithSum(int[] arr, int length, int target) {

        int min = length+1;
        for (int i = 0; i < length; i++) {
            int sum = arr[i];
            if (sum >= target){
                return 1;
            }
            for (int j = i+1; j < length; j++) {
                sum += arr[j];
                if (sum >= target && j-i+1 < min){
                    min = j-i+1;
                }
            }
        }
        if(min > length){
            return -1;
        }
        return min;
    }
}
