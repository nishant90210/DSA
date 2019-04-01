package Arrays;

/**
 * Created by NISHANT on 3/27/18.
 */
//https://www.geeksforgeeks.org/replace-every-element-with-the-greatest-on-right-side/
public class ReplaceEveryElement {

    //Naive
    public static void main(String[] args) {

        int arr[] = {16, 17, 4, 3, 5, 2};
//        nextGreatestNaive(arr);
        nextGreatestTricky(arr);
        System.out.println("The modified array:");
        printArray (arr);
    }

    private static void nextGreatestTricky(int[] arr) {

        int size = arr.length;
        int max = arr[size-1];
        for (int i = size-2; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = max;
            if (max < temp){
                max = temp;
            }
        }
        arr[size-1] = -1;
    }

    private static void nextGreatestNaive(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int max = -1;
            for (int j = i+1; j < arr.length; j++) {
                if (max < arr[j]){
                    max = arr[j];
                }
            }
            arr[i] = max;
        }
    }

    private static void printArray(int[] arr) {

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
