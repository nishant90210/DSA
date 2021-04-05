package Arrays;

/**
 * Created by NISHANT on 4/5/18.
 */
public class ArrayRotation {

    public static void main(String[] args)
    {
        int arr[] = {1,2,3,4,5,6,7};
        int k = 3;
//        for (int i = 0; i < k; i++) {
//            leftRotate(arr, k);
//        }
        rotate(arr, k);
        printArray(arr);
    }

    public static void rotate(int[] nums, int k) {
        /*
        Break the array into 2 parts (length - k) and rest array
        Reverse both of them separately,
        Finally reverse the complete array.
         */
        if(nums.length == 1) {
            return;
        }
        if (nums.length < k){
            return;
        }
        reverse(nums, 0, nums.length-1-k);
        reverse(nums, nums.length-k, nums.length-1);
        reverse(nums, 0, nums.length-1);
    }

    public static void reverse(int[] nums, int a, int b) {

        int start = a;
        int end = b;
        while(start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private static void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    private static void printArray(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void leftRotate(int[] arr, int k) {

        int j, temp;
        temp = arr[0];
        for (j = 0; j < arr.length-1; j++){
            arr[j] = arr[j+1];
        }
        arr[j] = temp;
    }

    private static void rightRotate(int[] arr, int k) {

        int temp, i;
        int length = arr.length;
        temp = arr[length - 1];
        for(i = length - 1; i > 0; i--){
            arr[i] = arr[i - 1];
        }
        arr[i] = temp;
    }
}
