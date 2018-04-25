package Arrays;

/**
 * Created by NISHANT on 4/5/18.
 */
public class ReverseArray {

    public static void main (String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6};
        int length = arr.length;
        printArray(arr, 6);
        reverseArray(arr, 0, length);
        System.out.println("Reversed array is ");
        printArray(arr, 6);
    }

    private static void reverseArray(int[] arr, int i, int length) {

        int start = 0;
        int end = length-1;
        while (start < end){
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    private static void swap(int[] arr, int start, int end) {

        int temp = 0;
        temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

    }

    private static void printArray(int[] arr, int i) {

        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }
    }
}
