package TopInterviewQuestions;

/**
 * Created by NISHANT on 4/11/18.
 */
public class PlaceMissingNumber {

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 5, 7};

        int number = -1;
        System.out.println(binarySearch(arr, number));
    }

    private static int binarySearch(int[] nums, int target) {


        int start = 0;
        int end = nums.length-1;
        while (start <= end){
            int mid = (start+end)/2;
            if(target == nums[mid]){
                return mid;
            }else if (target > nums[mid]) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return start;
    }
}
